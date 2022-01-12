import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CarService {

  constructor(
    private http: HttpClient
  ) { }


  addCar(data:{matricule: string, TypeV:string, color:string, datExpertassurance:Date}, id: string){
    return this.http.post(`http://localhost:8082/voiture/${id}`, data);
  }
}
