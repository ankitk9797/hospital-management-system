import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Appointment} from "../appointment/appointment";
import {HttpClient} from "@angular/common/http";
import {Login} from "./login";

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private baseUrl = "http://localhost:8080/api/login";

  constructor(private httpClient:HttpClient) { }

  getAdminByUsername(username : string):Observable<Login>{
    return this.httpClient.get<Login>(`${this.baseUrl}/admin/${username}`);
  }
  getDoctorByUsername(username : string):Observable<Login>{
    return this.httpClient.get<Login>(`${this.baseUrl}/doctor/${username}`);
  }
}
