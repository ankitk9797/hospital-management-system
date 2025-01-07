import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Patient} from "./patient";

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  constructor(private httpClient:HttpClient) { }

  private baseUrl = "http://localhost:8080/api/v1";

  getPatientList():Observable<Patient[]>{
    return this.httpClient.get<Patient[]>(`${this.baseUrl}`);
  }
  deletePatient(id:number):Observable<object>{
    return this.httpClient.delete(`${this.baseUrl}/patient/${id}`)
  }
  createPatient(patient:Patient):Observable<Patient>{
    return this.httpClient.post<Patient>(`${this.baseUrl}/insert`,patient);
  }
  getPatientById(id:number):Observable<Patient>{
    return this.httpClient.get<Patient>(`${this.baseUrl}/patient/${id}`)
  }
  updatePatientById(id:number,patient:Patient):Observable<Patient>{
    return this.httpClient.put<Patient>(`${this.baseUrl}/patient/${id}`,patient)
  }
}
