import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import { ChartsModule } from 'ng2-charts';

import {AppComponent} from './app.component';
import {LoginComponent} from './main/components/login/login.component';
import {routing} from "./config/routes";
import {HomeComponent} from './main/components/home/home.component';
import {SidebarComponent} from './common/components/sidebar/sidebar.component';
import {CoursesComponent} from './main/components/courses/courses.component';
import {HeaderComponent} from './common/components/sidebar/header/header.component';
import {CoursesService} from "./main/services/courses.service";
import {TeachersComponent} from './main/components/teachers/teachers.component';
import {TeachersService} from "./main/services/teachers.service";
import {CoursedetailComponent} from './main/components/courses/coursedetail/coursedetail.component';
import {TabsComponent} from "./common/components/tabs/tabs.component";
import { CourseinfoComponent } from './main/components/courses/coursedetail/courseinfo/courseinfo.component';
import { BooksComponent } from './main/components/courses/coursedetail/books/books.component';
import { ProjectsComponent } from './main/components/courses/coursedetail/projects/projects.component';
import { DocsComponent } from './main/components/courses/coursedetail/docs/docs.component';
import { AllbooksComponent } from './main/components/allbooks/allbooks.component';
import { TeacherdetailComponent } from './main/components/teachers/teacherdetail/teacherdetail.component';
import { TeacherinfoComponent } from './main/components/teachers/teacherdetail/teacherinfo/teacherinfo.component';
import { TeachergossipsComponent } from './main/components/teachers/teacherdetail/teachergossips/teachergossips.component';
import { CoursegossipsComponent } from './main/components/courses/coursedetail/coursegossips/coursegossips.component';
import { CoursegradesComponent } from './main/components/courses/coursedetail/coursegrades/coursegrades.component';
import { AllprojectsComponent } from './main/components/allprojects/allprojects.component';
import { AlldocumentsComponent } from './main/components/alldocuments/alldocuments.component';
import { NavbarComponent } from './common/components/navbar/navbar.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    SidebarComponent,
    CoursesComponent,
    HeaderComponent,
    TeachersComponent,
    CoursedetailComponent,
    TabsComponent,
    CourseinfoComponent,
    BooksComponent,
    ProjectsComponent,
    DocsComponent,
    AllbooksComponent,
    TeacherdetailComponent,
    TeacherinfoComponent,
    TeachergossipsComponent,
    CoursegossipsComponent,
    CoursegradesComponent,
    CoursegradesComponent,
    AllprojectsComponent,
    AlldocumentsComponent,
    NavbarComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    ChartsModule,
    routing
  ],
  providers: [
    CoursesService,
    TeachersService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
