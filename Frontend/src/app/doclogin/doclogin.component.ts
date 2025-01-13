import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {DocauthService} from "./docauth.service";
import {LoginService} from "../home/login.service";
import {Login} from "../home/login";
import {UserStorageService} from "../storage/user-stoarge.service";

@Component({
  selector: 'app-doclogin',
  templateUrl: './doclogin.component.html',
  styleUrl: './doclogin.component.css'
})
export class DocloginComponent {

  username:string='';
  password:string='';
  private login: Login = new Login();
  inValidLogin=false;

  constructor(private router:Router,private docauth:DocauthService){}

  checkLogin() {

    this.docauth.login(this.username, this.password)
      .subscribe(res =>{
        console.log(res);
        if(UserStorageService.isDoctorLoggedIn()){
          console.log('doctor');
          this.router.navigate(['docdash'])
          this.inValidLogin = false;
        }else{
          console.log('no');
          this.router.navigate(['doclogin']);
          this.inValidLogin = true;
        }
      }, error =>{
        console.log('BAD CREDENTIALS');
      })

    // void this.loginService.getDoctorByUsername(this.username).subscribe(data => {
    //   this.login = data;
    //   if (this.docauth.authenticate(this.username, this.password, this.login.password)) {
    //
    //     this.router.navigate(['docdash'])
    //     this.inValidLogin = false
    //
    //   } else {
    //     this.inValidLogin = true
    //     alert("Wrong Credintials")
    //     this.router.navigate(['home'])
    //
    //   }
    // });
  }

}
