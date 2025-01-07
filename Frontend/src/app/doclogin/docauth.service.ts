import { Injectable } from '@angular/core';
import {LoginService} from "../home/login.service";
import {Login} from "../home/login";

@Injectable({
  providedIn: 'root'
})
export class DocauthService {

  private login: Login = new Login();
  constructor(private loginService: LoginService) { }
  authenticate(username: string,password1:string,password2:string){

    if(password1==password2){
      sessionStorage.setItem('username_doctor',username);
      return true;
    }
    else {
      return false;
    }
  }

  isUserLoggedIn(){
    console.log("Logged In");
    let user=sessionStorage.getItem('username_doctor');
    return !(user==null);
  }
  logout(){
    sessionStorage.removeItem('username_doctor');
  }
}
