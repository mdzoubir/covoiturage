import { DashbordAdminComponent } from './components/dashbord-admin/dashbord-admin.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegistreComponent } from './components/registre/registre.component';
import { FormConvComponent } from './components/form-conv/form-conv.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: '/login',
    pathMatch: 'full'
  },
    {
      path: 'login',
      component: LoginComponent
  },
  {
    path:'home',
    component:HomeComponent
  }
  ,{
    path:'dashbordadmin',
    component:DashbordAdminComponent
  },
  {
    path:'registre',
    component:RegistreComponent
  },
  {
    path:'forme',
    component:FormConvComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
