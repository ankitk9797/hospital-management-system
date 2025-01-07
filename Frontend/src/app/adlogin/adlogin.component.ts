import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {DocauthService} from "../doclogin/docauth.service";
import {AdminauthService} from "./adminauth.service";
import {Login} from "../home/login";
import {LoginService} from "../home/login.service";

@Component({
  selector: 'app-adlogin',
  templateUrl: './adlogin.component.html',
  styleUrl: './adlogin.component.css'
})
export class AdloginComponent {

  username:string='';
  password:string='';

  inValidLogin=false;
  private login: Login = new Login();
  constructor(private router:Router,private adminAuth:AdminauthService, private loginService: LoginService){}

  checkLogin(){

    void this.loginService.getAdminByUsername(this.username).subscribe(data=>{
      this.login = data;
      if(this.adminAuth.authenticate(this.username,this.password,this.login.password)){

        this.router.navigate(['admin'])
        this.inValidLogin=false

      }
      else{
        this.inValidLogin=true
        alert("Wrong Credintials")
        this.router.navigate(['home'])

      }
    });
  }

}
