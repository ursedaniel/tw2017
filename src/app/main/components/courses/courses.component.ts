import {Component, OnInit, ViewChild} from '@angular/core';
import {CoursesService} from "../../services/courses.service";
import {Observable} from "rxjs";
import {PagerObject} from "../../interfaces/PagerObject";
import {SearchParams} from "../../interfaces/SearchParams";
import {Course} from "../../interfaces/Course";

@Component({
  selector: 'acar-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.css']
})
export class CoursesComponent implements OnInit {

  courses: any;
  @ViewChild('nameFilter') filterInput: any;
  private filterObs: any;
  private pager: PagerObject = new PagerObject();
  private searchParamas: SearchParams = new SearchParams();
  private searchObject: Course = new Course();

  constructor(private coursesService: CoursesService) { }

  ngOnInit() {
    this.getCourses();
    this.filterObs = Observable.fromEvent(this.filterInput.nativeElement, 'keyup')
      .debounceTime(500)
      .map(response => this.filterInput.nativeElement.value)
      .subscribe((value) => {
        this.searchObject.name = value;
        this.searchParamas.search = this.searchObject;
        this.getCoursesFiltered();
      });
  }

  getCourses() {
    this.coursesService.getCourses(this.searchParamas).subscribe(
      (response) => {
        this.courses = response.content;
        this.pager.totalPages = response.totalPages;
        this.pager.totalElements = response.totalElements;
      }
    );
  }

  getCoursesFiltered() {
    this.coursesService.getFilteredCourses(this.searchParamas).subscribe(
      (response) => {
        this.courses = response.content;
      }
    );
  }

  handlePageChanged(data) {
    this.searchParamas.page = this.pager.page;
    this.searchParamas.size = this.pager.rows;
    this.getCourses();
  }

}
