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
  private baseUrl = "http://localhost:8080/api/v3";

  getMedicines():Observable<Medicine[]>{
    return this.httpClient.get<Medicine[]>(`${this.baseUrl}`);
  }

  createMedicine(medicine:Medicine): Observable<Medicine>{
    return this.httpClient.post<Medicine>(`${this.baseUrl}/insert`,medicine);
  }
  getMedicineById(id:number):Observable<Medicine>{
    return this.httpClient.get<Medicine>(`${this.baseUrl}/medicine/${id}`)
  }
  updateMedicineById(id:number,medicine:Medicine):Observable<Medicine>{
    return this.httpClient.put<Medicine>(`${this.baseUrl}/medicine/${id}`,medicine)
  }
  deleteMedicine(id:number):Observable<Medicine>{
    return this.httpClient.delete<Medicine>(`${this.baseUrl}/medicine/${id}`)
  }
}
