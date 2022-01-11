import { HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

const TOKEN_KEY = 'auth-token';
const USER_KEY = 'auth-user';

const ROLE_USER  = 'user';
const ROLE_ADMIN  = 'admin';

@Injectable({
  providedIn: 'root'
})
export class TokenService {

  constructor(private http:HttpClientModule,private router:Router) {}

  signOut():void{
    window.sessionStorage.clear();
  }

  public saveToken(token:string):void{
    window.sessionStorage.removeItem(TOKEN_KEY);
    window.sessionStorage.setItem(TOKEN_KEY,token);
  }

  set(data: any){
    localStorage.setItem('token', data.accessToken);
    localStorage.setItem('id', data.id);
  }

  getId(){
    return localStorage.getItem('id');
  }


  getIsLoggin() {
    return localStorage.getItem('isLoggin');
  }


  remove(){
    localStorage.removeItem(TOKEN_KEY);
    localStorage.removeItem('id');
    localStorage.removeItem('isLoggin');
  }
  isValid(){
    const token = this.getToken();
    const id = this.getId();
    const isLoggin = this.getIsLoggin();
    if (isLoggin) {
      return true;
    }

    return false;
  }

  public getToken(): string | null {
    return window.sessionStorage.getItem(TOKEN_KEY);
  }

  public saveUser(user: any): void {
    window.sessionStorage.removeItem(USER_KEY);
    window.sessionStorage.setItem(USER_KEY, JSON.stringify(user));
  }


  public getUser(): any {
    const user = window.sessionStorage.getItem(USER_KEY);
    if (user) {
      return JSON.parse(user);
    }

    return {};
  }

  loggedIn(){
    return this.getToken();
   }

}

