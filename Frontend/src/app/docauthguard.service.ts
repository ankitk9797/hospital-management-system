import { Injectable } from '@angular/core';
import {
  ActivatedRouteSnapshot,
  CanActivate,
  GuardResult,
  MaybeAsync,
  Router,
  RouterStateSnapshot
} from "@angular/router";
import {DocauthService} from "./doclogin/docauth.service";
import {UserStorageService} from "./storage/user-stoarge.service";

@Injectable({
  providedIn: 'root'
})
export class DocauthguardService implements CanActivate{

  constructor(private router: Router) { }

  canActivate(){
    if(UserStorageService.isDoctorLoggedIn()){
      return true;
    } else {
      this.router.navigate(['doclogin']);
      return false;
    }
  }
}
