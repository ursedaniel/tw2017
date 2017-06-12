import {Component, OnInit, Input} from '@angular/core';
import {Project} from "../../../../interfaces/Project";
import {CoursesService} from "../../../../services/courses.service";

@Component({
  selector: 'acar-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css']
})
export class ProjectsComponent implements OnInit {

  @Input() courseId: any;

  projects: any;

  constructor(private coursesService: CoursesService) { }

  ngOnInit() {
    this.getProjects();
  }

  getProjects() {
    this.coursesService.getProjects(this.courseId).subscribe(
      (response) => {
        this.projects = response.content;
      }
    )
  }

}
