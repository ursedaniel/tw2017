/**
 * Created by Daniel on 4/21/2017.
 */
import {Routes, RouterModule}  from '@angular/router';
import {LoginComponent} from "../main/components/login/login.component";
import {HomeComponent} from "../main/components/home/home.component";
import {CoursesComponent} from "../main/components/courses/courses.component";

export const routes: Routes = [
    {path: 'login', component: LoginComponent},
    {path: 'home', component: HomeComponent},
    {path: 'courses', component: CoursesComponent},
    {path: '', redirectTo: '/home', pathMatch: 'full'}
];

export const appRoutingProviders: any[] = [];

export const routing = RouterModule.forRoot(routes);
