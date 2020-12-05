import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Params} from '@angular/router';
import {UserModel} from '../../../../shared/models/user.model';

@Component({
  selector: 'app-model-detail',
  templateUrl: './model-detail.component.html',
  styleUrls: ['./model-detail.component.css']
})
export class ModelDetailComponent implements OnInit {

  user;

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
          params.eMail,
          params.city,
          params.country,
          params.isModel,
          params.isPhotographer,
          params.biography,
          params.posts
        );
      }
    );
  }
}
