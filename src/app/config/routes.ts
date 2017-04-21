/**
 * Created by Daniel on 4/21/2017.
 */
import {Routes, RouterModule}  from '@angular/router';
import {LoginComponent} from "../main/components/login/login.component";
import {HomeComponent} from "../main/components/home/home.component";

export const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'home', component: HomeComponent},
  {path: '', redirectTo: '/home', pathMatch: 'full'}
];

export const appRoutingProviders: any[] = [];

export const routing = RouterModule.forRoot(routes);
