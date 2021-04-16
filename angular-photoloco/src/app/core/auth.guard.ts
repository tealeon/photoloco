import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router} from '@angular/router';
import { Observable } from 'rxjs';
import {UserService} from './services/user.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  loggedIn = false;

  constructor(
    private router: Router,
    private userService: UserService
  ) {
  }

  canActivate(next: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    this.userService.isLoggedIn().subscribe(
      value => {
        this.loggedIn = value;
      }
    );
    if (this.loggedIn) {
      return true;
    }
    this.router.navigate([''], { queryParams: { returnUrl: state.url }});
    return false;
  }
}
