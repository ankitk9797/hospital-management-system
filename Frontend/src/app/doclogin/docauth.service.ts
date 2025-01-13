import { Injectable } from '@angular/core';
import {AUTH_HEADER, LoginService} from "../home/login.service";
import {Login} from "../home/login";
import {map} from "rxjs";
import {HttpClient, HttpResponse} from "@angular/common/http";
import {UserStorageService} from "../storage/user-stoarge.service";

@Injectable({
  providedIn: 'root'
})
export class DocauthService {

  private baseUrl = "http://localhost:8080/";
  constructor(private httpClient: HttpClient,
              private userStorageService: UserStorageService) { }

  login(username:string, password:string){
    return this.httpClient.post(this.baseUrl +   "login", { username, password, role: "DOCTOR"}, { observe: 'response' })
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
  //     sessionStorage.setItem('username_doctor',username);
  //     return true;
  //   }
  //   else {
  //     return false;
  //   }
  // }

  // isUserLoggedIn(){
  //   console.log("Logged In");
  //   let user=sessionStorage.getItem('username_doctor');
  //   return !(user==null);
  // }
  // logout(){
  //   sessionStorage.removeItem('username_doctor');
  // }
}
