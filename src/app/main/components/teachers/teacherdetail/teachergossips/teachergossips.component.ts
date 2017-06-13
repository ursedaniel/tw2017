import {Component, OnInit, Input, ViewChild} from '@angular/core';
import {Gossip} from "../../../../interfaces/Gossip";
import {AddcoursegossipComponent} from "../../../courses/coursedetail/coursegossips/addcoursegossip/addcoursegossip.component";
import {AddteachergossipComponent} from "./addteachergossip/addteachergossip.component";
import {TeachersService} from "../../../../services/teachers.service";

@Component({
  selector: 'acar-teachergossips',
  templateUrl: './teachergossips.component.html',
  styleUrls: ['./teachergossips.component.css']
})
export class TeachergossipsComponent implements OnInit {

  @Input() teacherId: any;

  @ViewChild(AddteachergossipComponent)
  modalGossip: AddteachergossipComponent;

  gossips: any;

  constructor(private teachersService: TeachersService) { }

  ngOnInit() {
    this.getGossips();
  }

  getGossips() {
    this.teachersService.getGossips(this.teacherId).subscribe(
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
