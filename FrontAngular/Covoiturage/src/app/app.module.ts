import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { HomeComponent } from './components/home/home.component';
import { DashbordAdminComponent } from './components/dashbord-admin/dashbord-admin.component';
import { RegistreComponent } from './components/registre/registre.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HeadComponent } from './components/head/head.component';
import { HeaderComponent } from './components/header/header.component';
import { CovoiturageAccComponent } from './components/covoiturage-acc/covoiturage-acc.component';
import { AproposComponent } from './components/apropos/apropos.component';
import { PubComponent } from './components/pub/pub.component';
import { FooterComponent } from './components/footer/footer.component';
import {JwtInterceptor} from './interceptor/jwt.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    DashbordAdminComponent,
    RegistreComponent,
    NavbarComponent,
    HeadComponent,
    HeaderComponent,
    CovoiturageAccComponent,
    AproposComponent,
    PubComponent,
    FooterComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    NgbModule

  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: JwtInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
