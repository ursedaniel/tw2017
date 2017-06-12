import {Component, OnInit, Input} from '@angular/core';
import {Doc} from "../../../../interfaces/Doc";
import {CoursesService} from "../../../../services/courses.service";

@Component({
  selector: 'acar-docs',
  templateUrl: './docs.component.html',
  styleUrls: ['./docs.component.css']
})
export class DocsComponent implements OnInit {

  @Input() courseId: any;

  docs: any;

  constructor(private coursesService: CoursesService) { }

  ngOnInit() {
    this.getDocs();
  }

  getDocs() {
    this.coursesService.getDocs(this.courseId).subscribe(
      (response) => {
        this.docs = response.content;
      }
    )
  }

}
