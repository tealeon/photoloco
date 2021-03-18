import { Component, OnInit } from '@angular/core';
import {UserModel} from "../../../../shared/models/user.model";
import {ActivatedRoute, Params} from "@angular/router";
import {UserService} from "../../../../core/services/user.service";

@Component({
  selector: 'app-user-detail',
  templateUrl: './user-detail.component.html',
  styleUrls: ['./user-detail.component.css']
})
export class UserDetailComponent implements OnInit {

  user: UserModel;

  constructor(
    private route: ActivatedRoute,
    private userService: UserService
  ) {
  }

  ngOnInit(): void {
    this.route.params.subscribe(
      (params: Params) => {
        this.userService.getUserByInstagramName(params.instagramName).subscribe(value => {
          this.user = value;
        });
      }
    );
  }
}
