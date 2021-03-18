import { Component, OnInit } from '@angular/core';
import {UserService} from "../../../core/services/user.service";
import {UserModel} from "../../../shared/models/user.model";
import {Router} from "@angular/router";

@Component({
  selector: 'app-explore',
  templateUrl: './explore.component.html',
  styleUrls: ['./explore.component.css']
})
export class ExploreComponent implements OnInit {

  photographers: UserModel[] = [];
  models: UserModel[] = [];

  constructor(
    private userSerive: UserService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.userSerive.getAllUsers().subscribe(value => {
      console.log(value);
      this.photographers = value
        .filter(user => user.photographer)
        .sort((a, b) => {
          return b.photoShootingsInvolvedIn.length - a.photoShootingsInvolvedIn.length;
        })
        .slice(0, 3);
      this.models = value
        .filter(user => user.model)
        .sort((a, b) => {
          return b.photoShootingsInvolvedIn.length - a.photoShootingsInvolvedIn.length;
        })
        .slice(0, 3);
      console.log(this.photographers, this.models);
    });
  }

  navigateTouserDetail(instagramName: string): void {
    this.router.navigate(['user-detail', instagramName]);
  }
}
