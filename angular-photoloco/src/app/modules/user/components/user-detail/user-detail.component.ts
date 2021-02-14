import { Component, OnInit } from '@angular/core';
import {UserModel} from "../../../../shared/models/user.model";
import {ActivatedRoute, Params} from "@angular/router";

@Component({
  selector: 'app-user-detail',
  templateUrl: './user-detail.component.html',
  styleUrls: ['./user-detail.component.css']
})
export class UserDetailComponent implements OnInit {

  user: UserModel;

  constructor(
    private route: ActivatedRoute,
  ) {
  }

  ngOnInit(): void {
    this.route.params.subscribe(
      (params: Params) => {
        this.user = new UserModel(
          params.id,
          params.username,
          params.firstName,
          params.lastName,
          params.imageUrl,
          params.MMail,
          params.city,
          params.country,
          params.isModel,
          params.isPhotographer,
          params.biography,
          params.instagramName,
          params.websiteUrl,
          params.posts
        );
      }
    );
  }
}
