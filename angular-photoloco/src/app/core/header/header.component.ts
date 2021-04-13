import { Component, OnInit } from '@angular/core';
import {UserService} from '../services/user.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  loggedIn: boolean;

  constructor(private userService: UserService) { }

  ngOnInit(): void {
     this.userService.isLoggedIn().subscribe(isLoggedIn => {
       this.loggedIn = isLoggedIn;
     });
  }

}
