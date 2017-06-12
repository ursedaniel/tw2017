import {Component, OnInit, Input} from '@angular/core';
import {Project} from "../../../../interfaces/Project";
import {CoursesService} from "../../../../services/courses.service";
import {PagerObject} from "../../../../interfaces/PagerObject";
import {SearchParams} from "../../../../interfaces/SearchParams";

@Component({
  selector: 'acar-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css']
})
export class ProjectsComponent implements OnInit {

  @Input() courseId: any;
  private pager: PagerObject = new PagerObject();
  private searchParamas: SearchParams = new SearchParams();

  projects: any;

  constructor(private coursesService: CoursesService) { }

  ngOnInit() {
    this.getProjects();
  }

  getProjects() {
    this.coursesService.getProjects(this.courseId,this.searchParamas).subscribe(
      (response) => {
        this.projects = response.content;
        this.pager.totalPages = response.totalPages;
        this.pager.totalElements = response.totalElements;
      }
    )
  }

  handlePageChanged(data) {
    this.searchParamas.page = this.pager.page;
    this.searchParamas.size = this.pager.rows;
    this.getProjects();
  }


}
