import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Appointment} from "../appointment/appointment";
import {Medicine} from "./medicine";
import {Patient} from "../patient/patient";

@Injectable({
  providedIn: 'root'
})
export class MedicineService {

  constructor(private httpClient:HttpClient) { }
  private baseUrl = "http://localhost:8080/medicine";

  getMedicines():Observable<Medicine[]>{
    return this.httpClient.get<Medicine[]>(`${this.baseUrl}/allMedicines`);
  }

  createMedicine(medicine:Medicine): Observable<Medicine>{
    return this.httpClient.post<Medicine>(`${this.baseUrl}/create`,medicine);
  }
  getMedicineById(id:number):Observable<Medicine>{
    return this.httpClient.get<Medicine>(`${this.baseUrl}/${id}`)
  }
  updateMedicineById(id:number,medicine:Medicine):Observable<Medicine>{
    return this.httpClient.put<Medicine>(`${this.baseUrl}/update/${id}`,medicine)
  }
  deleteMedicine(id:number):Observable<Medicine>{
    return this.httpClient.delete<Medicine>(`${this.baseUrl}/delete/${id}`)
  }
}
