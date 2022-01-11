import { Component, OnInit } from '@angular/core';
import {CovoiturageService} from '../../services/covoiturage.service';
import {Covoiturage} from '../../models/covoiturage';

@Component({
  selector: 'app-all-cov',
  templateUrl: './all-cov.component.html',
  styleUrls: ['./all-cov.component.css']
})
export class AllCovComponent implements OnInit {
  p: number = 1;
  covoiturages : Covoiturage[] = [];

  constructor(private covoiturageService: CovoiturageService) { }

  ngOnInit(): void {
    this.getAllCov();
  }


  getAllCov(){
    this.covoiturageService.getCinqCovoiturage().subscribe((res: Covoiturage[]) => {
      this.covoiturages = res;
    })
  }

}
