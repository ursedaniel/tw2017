import {Component} from '@angular/core';
import {UsersService} from "./main/services/users.service";
import {User} from "./main/interfaces/User";

@Component({
  selector: 'acar-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  logged = 'false';
  user: User = new User();

  constructor(private usersService: UsersService) {
  };

  ngOnInit() {
    console.log(this.logged);
  }

  loggedIn(user) {
    this.user = user;
    this.logged = localStorage.getItem("logged");
    // console.log(user);
  }

  loggedOut(confirmation) {
    if (confirmation) {
      this.logged = 'false';
    }
  }
}
