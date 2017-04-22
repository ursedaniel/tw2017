import { Component, OnInit } from '@angular/core';
import {CoursesService} from "../../services/courses.service";

@Component({
  selector: 'acar-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.css']
})
export class CoursesComponent implements OnInit {

  courses: any;

  constructor(private coursesService: CoursesService) { }

  ngOnInit() {
    this.coursesService.getCourses().subscribe(
      (response) => {
        this.courses = response.content;
      }
    );
  }

}
