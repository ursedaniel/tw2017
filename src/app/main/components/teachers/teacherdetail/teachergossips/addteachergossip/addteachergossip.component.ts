import {Component, OnInit, ViewChild, Output, EventEmitter} from '@angular/core';
import {ModalComponent} from "ng2-bs3-modal/components/modal";
import {Gossip} from "../../../../../interfaces/Gossip";
import {GossipsService} from "../../../../../services/gossips.service";

@Component({
  selector: 'acar-addteachergossip',
  templateUrl: './addteachergossip.component.html',
  styleUrls: ['./addteachergossip.component.css']
})
export class AddteachergossipComponent implements OnInit {


  @ViewChild(ModalComponent)
  modalGossip: ModalComponent;
  gossip: Gossip = new Gossip();
  @Output() pageChanged = new EventEmitter();
  err: boolean;

  constructor(private gossipsService: GossipsService) {
  }

  ngOnInit() {
  }


  open(teacherId) {
    this.gossip.teacher_id = teacherId;
    this.err = false;
    this.modalGossip.open();
  }

  close() {
    this.modalGossip.close();
  }

  addGossip() {
    this.gossip.posting_date = new Date().toJSON().slice(0,10).replace(/-/g,'/');
    this.gossipsService.addGossip(this.gossip).subscribe(
      (succes) => {
        this.modalGossip.close();
        this.pageChanged.emit(true);
      },
      (error) => {
        this.err = true;
      },
      () => {
      }
    );
  }

}
