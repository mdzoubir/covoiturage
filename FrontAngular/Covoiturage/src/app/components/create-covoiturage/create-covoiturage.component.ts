import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {NgbDateStruct, NgbCalendar} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-create-covoiturage',
  templateUrl: './create-covoiturage.component.html',
  styleUrls: ['./create-covoiturage.component.css']
})
export class CreateCovoiturageComponent implements OnInit {
  voitureForm: FormGroup;
  covoiturageForm: FormGroup;
  model: NgbDateStruct;
  date: { year: number, month: number };

  constructor(public fb: FormBuilder, public calendar: NgbCalendar) {
    this.voitureForm = this.fb.group({
      matricule: [null],
      typev: [null, Validators.required],
      color: [null, Validators.required],
      dat_expertassurance: [null, Validators.required],
    });

    this.covoiturageForm = this.fb.group({
      date_depart: [null, Validators.required],
      date_arrive: [null, Validators.required],
      heure_depart: [null, Validators.required],
      heure_arrivée: [null, Validators.required],
      prix: [null, Validators.required],
      ville_départ: [null, Validators.required],
      ville_arrivée: [null, Validators.required],
      adresse_depart: [null, Validators.required],
      nombre_place: [null, Validators.required],
    });
  }

  ngOnInit(): void {
  }

  selectToday() {
    this.model = this.calendar.getToday();
  }

}
