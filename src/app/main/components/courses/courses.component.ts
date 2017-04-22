import {Component, OnInit, ViewChild} from '@angular/core';
import {CoursesService} from "../../services/courses.service";
import {Observable} from "rxjs";

@Component({
  selector: 'acar-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.css']
})
export class CoursesComponent implements OnInit {

  courses: any;
  @ViewChild('nameFilter') filterInput: any;
  private filterObs: any;

  constructor(private coursesService: CoursesService) { }

  ngOnInit() {
    this.getCourses();
    this.filterObs = Observable.fromEvent(this.filterInput.nativeElement, 'keyup')
      .debounceTime(500)
      .map(response => this.filterInput.nativeElement.value)
      .subscribe((value) => {
        this.getCoursesFiltered(value);
      });
  }

  getCourses() {
    this.coursesService.getCourses().subscribe(
      (response) => {
        this.courses = response.content;
      }
    );
  }

  getCoursesFiltered(value) {
    this.coursesService.getFilteredCourses(value).subscribe(
      (response) => {
        this.courses = response.content;
      }
    );
  }

}
