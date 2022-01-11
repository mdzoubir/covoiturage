import { DashbordAdminComponent } from './components/dashbord-admin/dashbord-admin.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegistreComponent } from './components/registre/registre.component';
import {AllCovComponent} from './components/all-cov/all-cov.component';
import {AuthGuard} from './guard/auth.guard';
import {AfterAuthGuard} from './guard/after-auth.guard';

const routes: Routes = [
  {
    path: '',
    redirectTo: '/login',
    pathMatch: 'full'
  },
    {
      path: 'login',
      canActivate: [AfterAuthGuard],
      component: LoginComponent
  },
  {
    path:'home',
    canActivate: [AuthGuard],
    component:HomeComponent
  }
  ,{
    path:'dashbordadmin',
    canActivate: [AuthGuard],
    component:DashbordAdminComponent
  },
  {
    path:'registre',
    canActivate: [AfterAuthGuard],
    component:RegistreComponent
  },
  {
    path: 'allCov',
    canActivate: [AuthGuard],
    component: AllCovComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
