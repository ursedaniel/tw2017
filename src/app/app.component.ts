import { Component } from '@angular/core';

@Component({
  selector: 'acar-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  logged = false;

  loggedIn() {
    this.logged = true;
    console.log("logat");
  }
}
