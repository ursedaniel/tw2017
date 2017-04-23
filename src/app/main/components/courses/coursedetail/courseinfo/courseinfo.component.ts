import {Component, OnInit, Input} from '@angular/core';
import {CoursesService} from "../../../../services/courses.service";
import {Course} from "../../../../interfaces/Course";

@Component({
  selector: 'acar-courseinfo',
  templateUrl: './courseinfo.component.html',
  styleUrls: ['./courseinfo.component.css']
})
export class CourseinfoComponent implements OnInit {

  course: Course = new Course();

  @Input() private courseId:any;

  constructor(private coursesService: CoursesService) { }

  ngOnInit() {
    this.getCourse(this.courseId);
  }

  getCourse(id) {
    this.coursesService.getCourse(id).subscribe(
      (response) => {
        this.course = response;
        console.log(this.course);
      }
    )
  }

}
