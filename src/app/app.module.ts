import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { LoginComponent } from './main/components/login/login.component';
import {routing} from "./config/routes";
import { HomeComponent } from './main/components/home/home.component';
import { SidebarComponent } from './common/components/sidebar/sidebar.component';
import { CoursesComponent } from './main/components/courses/courses.component';
import { HeaderComponent } from './common/components/sidebar/header/header.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    SidebarComponent,
    CoursesComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routing
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
