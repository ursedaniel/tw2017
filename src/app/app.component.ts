import { Component } from '@angular/core';

@Component({
  selector: 'acar-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  logged = true;

  loggedIn() {
    this.logged = true;
    console.log("logat");
  }
}
