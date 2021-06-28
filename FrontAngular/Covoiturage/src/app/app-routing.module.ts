import { DashbordAdminComponent } from './components/dashbord-admin/dashbord-admin.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegistreComponent } from './components/registre/registre.component';

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
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
