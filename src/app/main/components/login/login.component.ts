import {Component, OnInit, Input, EventEmitter, Output} from '@angular/core';
import {User} from "../../interfaces/User";
import {UsersService} from "../../services/users.service";

declare const FB: any;
@Component({
  selector: 'acar-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: User = new User();

  @Output() pageChanged = new EventEmitter();


  constructor(private usersService: UsersService) {
    FB.init({
      appId: '117516122175287',
      secret: '3f8755ef004e21d6e2cb0a9e25f1c6a6',
      cookie: false,  // enable cookies to allow the server to access
      // the session
      xfbml: true,  // parse social plugins on this page
      version: 'v2.5', // use graph api version 2.5,
      redirectURI: 'http://acar.pagekite.me',
      authEndpoint: 'http://acar.pagekite.me',
      oauth:true,
      email: true
    });
  }

  ngOnInit() {
    localStorage.setItem("logged","false");
  }

  checkLogged () {
    FB.getLoginStatus(response => {
      this.statusChangeCallback(response);
    });
  }


  statusChangeCallback(resp) {
    if (resp.status == 'connected') {
      var self = this;
      // connect here with your server for facebook login by passing access token given by facebook
          console.log('Welcome!  Fetching your information.... ');
          FB.api('/me', {"fields": "id,name"},
            function (response) {
              this.user = response;
              this.user.role = 'user';
              localStorage.setItem("logged", 'true');
              self.emit(this.user);
            },
          );
        }

    else if (resp.status == 'not_authorized') {
      var self = this;
      self.onFacebookLoginClick();
    } else {
      var self = this;
      self.onFacebookLoginClick();
    }
  };


  public onFacebookLoginClick(): void {

    FB.init({
      appId: '117516122175287',
      secret: '3f8755ef004e21d6e2cb0a9e25f1c6a6',
      cookie: false,  // enable cookies to allow the server to access
      // the session
      xfbml: true,  // parse social plugins on this page
      version: 'v2.5', // use graph api version 2.5
      redirectURI: 'http://acar.pagekite.me',
      authEndpoint: 'http://acar.pagekite.me',
      oauth:true,
      email: true
    });
    FB.login(function(response) {
      if (response.authResponse) {
        console.log('Welcome!  Fetching your information.... ');
        FB.api('/me', {"fields":"id,name,email"},
          function (response) {
          console.log(response);
            this.user = response;
            this.user.role = 'user';
            localStorage.setItem("userId",this.user.id);
            localStorage.setItem("userName",this.user.name);
            localStorage.setItem("userRole",this.user.role);
            console.log(this.user);
            self.login(this.user);
          },
        );
      } else {
        console.log('User cancelled login or did not fully authorize.');
      }
    });
    var self = this;

  }

  public login(user): void {
    this.usersService.login(user).subscribe(
      (succes) => {
        this.user = user;
        localStorage.setItem("logged",'true');
        this.pageChanged.emit(user);
        this.emit(user);
      }
    )
  }

  emit(user) {
    console.log(user);
    this.pageChanged.emit(user);
  }

}
