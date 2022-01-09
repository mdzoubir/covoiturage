import { Component, OnInit } from '@angular/core';
import {Covoiturage} from '../../models/covoiturage';
import {CovoiturageService} from '../../services/covoiturage.service';

@Component({
  selector: 'app-covoiturage-acc',
  templateUrl: './covoiturage-acc.component.html',
  styleUrls: ['./covoiturage-acc.component.css']
})
export class CovoiturageAccComponent implements OnInit {

  covoiturages: Covoiturage[] = []

  constructor(private covoiturageService: CovoiturageService) { }

  ngOnInit(): void {
    this.getAll();
  }


  getAll(){
    this.covoiturageService.getAllCovoiturage().subscribe(
      (res: Covoiturage[]) => {
        this.covoiturages = res;
      }
    )
  }

}
