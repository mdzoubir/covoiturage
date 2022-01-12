import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {CarService} from '../../services/car.service';
import {TokenService} from '../../services/token.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-add-car',
  templateUrl: './add-car.component.html',
  styleUrls: ['./add-car.component.css']
})
export class AddCarComponent implements OnInit {

  constructor(
    private carService: CarService,
    private tokenService: TokenService,
    private route: Router
  ) { }

  addCarForm = new FormGroup({
    matricule: new FormControl(null, Validators.required),
    typeV: new FormControl(null, Validators.required),
    color: new FormControl(null, Validators.required),
    datExpertassurance: new FormControl(null, Validators.required)
  })

  ngOnInit(): void {
  }

  addNewCar(){
    this.carService.addCar(this.addCarForm.value, this.tokenService.getId()).subscribe();
    this.route.navigateByUrl("/home");
  }



}
