/**
 * Created by Daniel on 4/21/2017.
 */
import {Routes, RouterModule}  from '@angular/router';
import {LoginComponent} from "../main/components/login/login.component";
import {HomeComponent} from "../main/components/home/home.component";
import {CoursesComponent} from "../main/components/courses/courses.component";
import {TeachersComponent} from "../main/components/teachers/teachers.component";
import {CoursedetailComponent} from "../main/components/courses/coursedetail/coursedetail.component";
import {AllbooksComponent} from "../main/components/allbooks/allbooks.component";
import {TeacherdetailComponent} from "../main/components/teachers/teacherdetail/teacherdetail.component";
import {AllprojectsComponent} from "../main/components/allprojects/allprojects.component";
import {AlldocumentsComponent} from "../main/components/alldocuments/alldocuments.component";
import {ScheduleComponent} from "../main/components/schedule/schedule.component";

export const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'courses', component: CoursesComponent},
  {path: 'courses/:id', component: CoursedetailComponent},
  {path: 'teachers', component: TeachersComponent},
  {path: 'teachers/:id', component: TeacherdetailComponent},
  {path: 'books', component: AllbooksComponent},
  {path: 'schedule', component: ScheduleComponent},
  {path: 'projects', component: AllprojectsComponent},
  {path: 'documents', component: AlldocumentsComponent},
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: '**', redirectTo: '/home', pathMatch: 'full'}
];

export const appRoutingProviders: any[] = [];

export const routing = RouterModule.forRoot(routes);
