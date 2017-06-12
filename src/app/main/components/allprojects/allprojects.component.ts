import {Component, OnInit, ViewChild} from '@angular/core';
import {Project} from "../../interfaces/Project";
import {PagerObject} from "../../interfaces/PagerObject";
import {SearchParams} from "../../interfaces/SearchParams";
import {ProjectsService} from "../../services/projects.service";
import {Observable} from "rxjs";

@Component({
  selector: 'acar-allprojects',
  templateUrl: './allprojects.component.html',
  styleUrls: ['./allprojects.component.css']
})
export class AllprojectsComponent implements OnInit {

  projects: any;
  @ViewChild('nameFilter') filterInput: any;
  private filterObs: any;
  private pager: PagerObject = new PagerObject();
  private searchParamas: SearchParams = new SearchParams();
  private searchObject: Project = new Project();

  constructor(private projectsService: ProjectsService) { }

  ngOnInit() {
    this.getProjects();
    this.filterObs = Observable.fromEvent(this.filterInput.nativeElement, 'keyup')
      .debounceTime(500)
      .map(response => this.filterInput.nativeElement.value)
      .subscribe((value) => {
        this.searchObject.title = value;
        this.searchParamas.search = this.searchObject;
        this.getProjectsFiltered();
      });
  }

  getProjects() {
    this.projectsService.getProjects(this.searchParamas).subscribe(
      (response) => {
        this.projects = response.content;
        this.pager.totalPages = response.totalPages;
        this.pager.totalElements = response.totalElements;
      }
    );
  }

  getProjectsFiltered() {
    this.projectsService.getFilteredProjects(this.searchParamas).subscribe(
      (response) => {
        this.projects = response.content;
      }
    );
  }

  handlePageChanged(data) {
    this.searchParamas.page = this.pager.page;
    this.searchParamas.size = this.pager.rows;
    this.getProjects();
  }

}
