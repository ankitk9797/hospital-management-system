import { Injectable } from '@angular/core';
import {map, Observable} from "rxjs";
import {Appointment} from "../appointment/appointment";
import {Login} from "../home/login";
import {AUTH_HEADER, LoginService} from "../home/login.service";
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Router} from "@angular/router";
import {DocauthService} from "../doclogin/docauth.service";
import {UserStorageService} from "../storage/user-stoarge.service";

@Injectable({
  providedIn: 'root'
})
export class AdminauthService {

  private baseUrl = "http://localhost:8080/";
  constructor(private httpClient: HttpClient,
              private userStorageService: UserStorageService) { }

  login(username:string, password:string){
    return this.httpClient.post(this.baseUrl +   "login", { username, password, role: "ADMIN"}, { observe: 'response' })
      .pipe(
        map((res: HttpResponse<any>) =>{
          console.log(res.body)
          this.userStorageService.saveUser(res.body);

          const authHeader = res.headers.get(AUTH_HEADER);
          if (authHeader && authHeader.startsWith('Bearer ')) {
            const bearerToken = authHeader.substring(7); // Remove 'Bearer ' prefix
            console.log(bearerToken);
            this.userStorageService.saveToken(bearerToken); // Save the token
          } else {
            console.error('Authorization header is missing or invalid');
          }

          return res;

        })
      );
  }
  // authenticate(username: string,password1:string,password2:string){
  //
  //   if(password1==password2){
  //     sessionStorage.setItem('username',username);
  //     return true;
  //   }
  //   else {
  //     return false;
  //   }
  // }

  // isUserLoggedIn(){
  //   console.log("Logged In");
  //   let user=sessionStorage.getItem('username');
  //   return !(user==null);
  // }
  // logout(){
  //   sessionStorage.removeItem('username');
  // }

}
