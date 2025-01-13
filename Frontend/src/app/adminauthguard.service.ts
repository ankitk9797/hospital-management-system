import { Injectable } from '@angular/core';
import {
  ActivatedRouteSnapshot,
  CanActivate,
  GuardResult,
  MaybeAsync,
  Router,
  RouterStateSnapshot
} from "@angular/router";
import {AdminauthService} from "./adlogin/adminauth.service";
import {UserStorageService} from "./storage/user-stoarge.service";

@Injectable({
  providedIn: 'root'
})
export class AdminauthguardService implements CanActivate{

  constructor(private adminAuthService:AdminauthService, private router:Router) {
  }

  canActivate() {
    if(UserStorageService.isAdminLoggedIn()){
      return true;
    } else {
      this.router.navigate(['adlogin']);
      return false;
    }
  }
}
