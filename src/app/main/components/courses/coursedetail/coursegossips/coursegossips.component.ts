import {Component, OnInit, Input} from '@angular/core';
import {Gossip} from "../../../../interfaces/Gossip";
import {CoursesService} from "../../../../services/courses.service";

@Component({
  selector: 'acar-coursegossips',
  templateUrl: './coursegossips.component.html',
  styleUrls: ['./coursegossips.component.css']
})
export class CoursegossipsComponent implements OnInit {

  @Input() courseId: any;

  gossips: any;

  constructor(private coursesService: CoursesService) { }

  ngOnInit() {
    this.getGossips();
  }

  getGossips() {
    this.coursesService.getGossips(this.courseId).subscribe(
      (response) => {
        this.gossips = response.content;
      }
    )
  }

}
