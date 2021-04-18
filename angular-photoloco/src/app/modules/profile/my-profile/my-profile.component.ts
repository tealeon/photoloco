import { Component, OnInit } from '@angular/core';
import {UserService} from '../../../core/services/user.service';
import {UserModel} from '../../../shared/models/user.model';

@Component({
  selector: 'app-my-profile',
  templateUrl: './my-profile.component.html',
  styleUrls: ['./my-profile.component.css']
})
export class MyProfileComponent implements OnInit {

  user: UserModel;

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.userService.getUserValue().subscribe(value => {
      this.user = value;
    });
  }

  logout() {
    this.userService.logout();
  }
}
