import {Component, OnInit, Input, Output, EventEmitter} from '@angular/core';
import {User} from "../../../main/interfaces/User";

@Component({
  selector: 'acar-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {

  @Output() pageChanged = new EventEmitter();
  @Input() public user : User;
  constructor() { }

  ngOnInit() {
  }

  logOut() {
    this.pageChanged.emit(true);
  }

}
