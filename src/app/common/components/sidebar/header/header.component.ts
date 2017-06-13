import {Component, OnInit, Input} from '@angular/core';
import {User} from "../../../../main/interfaces/User";

@Component({
  selector: 'acar-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  @Input() public user : User;
  constructor() { }

  ngOnInit() {
    this.user.name = localStorage.getItem("userName");
    this.user.role = localStorage.getItem("userRole");
    console.log(localStorage.getItem("userRole"));
  }

}
