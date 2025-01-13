import { Injectable } from '@angular/core';
import {map, Observable} from "rxjs";
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Login} from "./login";
import {UserStorageService} from "../storage/user-stoarge.service";

export const AUTH_HEADER = 'authorization';
@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private baseUrl = "http://localhost:8080/";

  constructor(private httpClient: HttpClient,
              private userStorageService: UserStorageService) { }

  getAdminByUsername(username : string):Observable<Login>{
    return this.httpClient.get<Login>(`${this.baseUrl}/admin/${username}`);
  }
  getDoctorByUsername(username : string):Observable<Login>{
    return this.httpClient.get<Login>(`${this.baseUrl}/doctor/${username}`);
  }

  login(username:string, password:string){
    return this.httpClient.post(this.baseUrl +   "authenticate", { username, password}, { observe: 'response' })
      .pipe(
        map((res: HttpResponse<any>) =>{
          console.log(res.body)
          this.userStorageService.saveUser(res.body);

// Extract token from the header
          const authHeader = res.headers.get(AUTH_HEADER);
          if (authHeader && authHeader.startsWith('Bearer ')) {
            const bearerToken = authHeader.substring(7); // Remove 'Bearer ' prefix
            console.log(bearerToken);
            this.userStorageService.saveToken(bearerToken); // Save the token
          } else {
            console.error('Authorization header is missing or invalid');
          }

// Return the response object
          return res;

        })
      );
  }
}
