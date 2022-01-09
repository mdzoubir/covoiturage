import { Router } from '@angular/router';
import { AuthService } from './../../services/auth.service';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-registre',
  templateUrl: './registre.component.html',
  styleUrls: ['./registre.component.css']
})
export class RegistreComponent implements OnInit {




  registreForm=new FormGroup(
    {
      fullName:new FormControl(null,[Validators.required,Validators.required]),
      username:new FormControl(null,[Validators.required,Validators.required]),
      email:new FormControl(null,[Validators.required,Validators.email]),
      password:new FormControl(null,[Validators.required,Validators.minLength(8),Validators.maxLength(16)]),
      telephone:new FormControl(null,[Validators.required])
    }
  )
  constructor(private authService:AuthService,private router:Router) {

  }

  ngOnInit(): void {}

  onSubmit(): void {
    const { fullName,username, email, password ,telephone} = this.registreForm.value;

    this.authService.register(fullName,username, email, password,telephone).subscribe
    (data =>console.log(data),error=>console.log(error) );

    this.goTologin();

  }

  goTologin(){
    this.router.navigate(['/login']);
  }

}
