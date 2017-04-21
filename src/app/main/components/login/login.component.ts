import {Component, OnInit, Input, EventEmitter, Output} from '@angular/core';

@Component({
  selector: 'acar-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  @Output() pageChanged = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  loggedIn() {
    this.pageChanged.emit();
  }

}
