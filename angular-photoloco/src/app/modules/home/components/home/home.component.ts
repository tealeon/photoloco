import { Component, OnInit } from '@angular/core';
import {UserService} from '../../../../core/services/user.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  loggedIn: boolean;

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.userService.isLoggedIn().subscribe(isLoggedIn => {
      this.loggedIn = isLoggedIn;
    });
  }

}
