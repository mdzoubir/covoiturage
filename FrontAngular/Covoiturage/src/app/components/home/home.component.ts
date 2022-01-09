import { TokenService } from './../../services/token.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {CovoiturageService} from '../../services/covoiturage.service';
import {Covoiturage} from '../../models/covoiturage';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(
    private tokenService:TokenService,
    private router:Router
  ) { }

  ngOnInit(): void {
  }

  logout(): void {
    this.tokenService.signOut();
    this.router.navigateByUrl("/login")
  }

}
