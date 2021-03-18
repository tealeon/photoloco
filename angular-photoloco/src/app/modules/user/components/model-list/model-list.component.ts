import {Component, OnInit} from '@angular/core';
import {UserModel} from '../../../../shared/models/user.model';
import {Router} from '@angular/router';
import {UserService} from '../../../../core/services/user.service';

@Component({
  selector: 'app-model-list',
  templateUrl: './model-list.component.html',
  styleUrls: ['./model-list.component.css']
})
export class ModelListComponent implements OnInit {

  models: Array<UserModel>;

  constructor(
    private router: Router,
    private userService: UserService
  ) {
  }

  ngOnInit(): void {
    this.userService.getModelList().subscribe(
      data => {
        this.models = data;
      }
    );
  }

  getModelList(): Array<UserModel> {
    return this.models;
  }

  showModelDetails(user) {
    user.posts = JSON.stringify(user.posts);
    this.router.navigate(['user-detail', user.instagramName]);
  }

}
