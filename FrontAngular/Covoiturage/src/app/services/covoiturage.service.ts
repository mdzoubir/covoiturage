import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from 'rxjs';
import {Covoiturage} from '../models/covoiturage';


@Injectable({
  providedIn: 'root'
})

export class CovoiturageService {

  constructor(
    private http : HttpClient
  ) { }

  getAllCovoiturage(): Observable<Covoiturage[]>{
    return this.http.get<Covoiturage[]>('http://localhost:8082/covoiturage/getAllConvoi');
  }
}
