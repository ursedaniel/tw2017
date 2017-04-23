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

export const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'home', component: HomeComponent},
  {path: 'courses', component: CoursesComponent},
  {path: 'courses/:id', component: CoursedetailComponent},
  {path: 'teachers', component: TeachersComponent},
  {path: 'teachers/:id', component: TeacherdetailComponent},
  {path: 'books', component: AllbooksComponent},
  {path: '', redirectTo: '/home', pathMatch: 'full'}
];

export const appRoutingProviders: any[] = [];

export const routing = RouterModule.forRoot(routes);
