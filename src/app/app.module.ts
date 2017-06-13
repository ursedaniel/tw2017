import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule, XHRBackend, RequestOptions} from '@angular/http';
import { ChartsModule } from 'ng2-charts';
import { InterceptorService } from 'ng2-interceptors';

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
import { AllprojectsComponent } from './main/components/allprojects/allprojects.component';
import { AlldocumentsComponent } from './main/components/alldocuments/alldocuments.component';
import { NavbarComponent } from './common/components/navbar/navbar.component';
import {PaginationComponent} from "./common/components/pagination/pagination.component";
import {BooksService} from "./main/services/books.service";
import {ProjectsService} from "./main/services/projects.service";
import {DocsService} from "./main/services/docs.service";
import { AddcoursegossipComponent } from './main/components/courses/coursedetail/coursegossips/addcoursegossip/addcoursegossip.component';
import {GossipsService} from "./main/services/gossips.service";
import {Ng2Bs3ModalModule} from "ng2-bs3-modal/ng2-bs3-modal";
import {UsersService} from "./main/services/users.service";
import { ScheduleComponent } from './main/components/schedule/schedule.component';
import {ScheduleService} from "./main/services/schedule.service";
import { AddteachergossipComponent } from './main/components/teachers/teacherdetail/teachergossips/addteachergossip/addteachergossip.component';

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
    AllprojectsComponent,
    AlldocumentsComponent,
    NavbarComponent,
    PaginationComponent,
    AddcoursegossipComponent,
    ScheduleComponent,
    AddteachergossipComponent
  ],
  imports: [
    Ng2Bs3ModalModule,
    BrowserModule,
    FormsModule,
    HttpModule,
    ChartsModule,
    routing
  ],
  providers: [
    CoursesService,
    TeachersService,
    BooksService,
    ProjectsService,
    DocsService,
    GossipsService,
    UsersService,
    ScheduleService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
