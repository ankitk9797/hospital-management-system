import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {DocauthService} from "../doclogin/docauth.service";
import {AdminauthService} from "./adminauth.service";
import {Login} from "../home/login";
import {LoginService} from "../home/login.service";
import {UserStorageService} from "../storage/user-stoarge.service";

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
  constructor(private router:Router,private adminAuth:AdminauthService,){}

  checkLogin(){

    this.adminAuth.login(this.username, this.password)
        .subscribe(res =>{
          console.log(res);
          if(UserStorageService.isAdminLoggedIn()){
            console.log('admin');
            this.router.navigate(['admin'])
            this.inValidLogin = false;
          }else{
            console.log('no');
            this.router.navigate(['adlogin']);
            this.inValidLogin = true;
          }
        }, error =>{
          console.log('BAD CREDENTIALS');
        })

    // void this.loginService.getAdminByUsername(this.username).subscribe(data=>{
    //   this.login = data;
    //   if(this.adminAuth.login(this.username,this.password,this.login.password)){
    //
    //     this.router.navigate(['admin'])
    //     this.inValidLogin=false
    //
    //   }
    //   else{
    //     this.inValidLogin=true
    //     alert("Wrong Credintials")
    //     this.router.navigate(['home'])
    //
    //   }
    // });
  }

}
