import {Component, OnInit, Input, ViewChild} from '@angular/core';
import {CoursesService} from "../../../../services/courses.service";
import {AddcoursegossipComponent} from "./addcoursegossip/addcoursegossip.component";

@Component({
  selector: 'acar-coursegossips',
  templateUrl: './coursegossips.component.html',
  styleUrls: ['./coursegossips.component.css']
})
export class CoursegossipsComponent implements OnInit {

  @Input() courseId: any;
  @ViewChild(AddcoursegossipComponent)
  modalGossip: AddcoursegossipComponent;

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

  handleAdd(confirmation) {
    if(confirmation)
    {
      this.getGossips();
    }
  }

}
