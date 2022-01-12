import { DashbordAdminComponent } from './components/dashbord-admin/dashbord-admin.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegistreComponent } from './components/registre/registre.component';
import {AllCovComponent} from './components/all-cov/all-cov.component';
import {AuthGuard} from './guard/auth.guard';
import {AfterAuthGuard} from './guard/after-auth.guard';
import {CreateCovoiturageComponent} from './components/create-covoiturage/create-covoiturage.component';
import {AddCarComponent} from './components/add-car/add-car.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: '/home',
    pathMatch: 'full'
  },
    {
      path: 'login',
      canActivate: [AfterAuthGuard],
      component: LoginComponent
  },
  {
    path:'home',
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
    component: AllCovComponent
  },
  {
    path: 'add-covoiturage',
    component: CreateCovoiturageComponent
  },
  {
    path: 'add-car',
    component: AddCarComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
