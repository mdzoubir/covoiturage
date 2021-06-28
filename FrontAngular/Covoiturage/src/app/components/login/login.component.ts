import { TokenService } from './../../services/token.service';
import { AuthService } from './../../services/auth.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  
  loginForm=new FormGroup(
    {
      username:new FormControl(null,[Validators.required,Validators.required]),
      password:new FormControl(null,[Validators.required,Validators.minLength(8),Validators.maxLength(16)])

    ,})
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];

  constructor(private authService:AuthService,private tokenservice:TokenService,private router:Router) { }

  ngOnInit(): void {
    if(this.tokenservice.getToken()){
      this.roles = this.tokenservice.getUser().roles
      console.log(this.tokenservice.getUser())
      if(Array.from(this.roles).includes("ROLE_ADMIN")){
        this.router.navigateByUrl("/dashbordadmin")
      }else{
        this.router.navigateByUrl("/home")
      }
    }
  }

  onSubmit(): void {
    const { username, password } = this.loginForm.value;


    this.authService.login(username,password).subscribe(
      data => {
        console.log(data)
        this.isLoggedIn = true;
        this.tokenservice.saveToken(data.accessToken);
        this.tokenservice.saveUser(data);
        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.roles = this.tokenservice.getUser().roles;
        this.reloadPage();
      },



      err => {
        this.errorMessage = err.error.message;
        this.isLoginFailed = true;
      }
    );
  }

  reloadPage(): void {
    window.location.reload();
  }

}
