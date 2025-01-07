import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Appointment} from "../appointment/appointment";
import {Login} from "../home/login";
import {LoginService} from "../home/login.service";

@Injectable({
  providedIn: 'root'
})
export class AdminauthService {
  constructor() { }
  authenticate(username: string,password1:string,password2:string){

    if(password1==password2){
      sessionStorage.setItem('username',username);
      return true;
    }
    else {
      return false;
    }
  }

  isUserLoggedIn(){
    console.log("Logged In");
    let user=sessionStorage.getItem('username');
    return !(user==null);
  }
  logout(){
    sessionStorage.removeItem('username');
  }

}
