import {Component, OnInit} from '@angular/core';
import {UserModel} from '../../../../shared/models/user.model';
import {Router} from '@angular/router';
import {UserService} from '../../../../core/services/user.service';

@Component({
  selector: 'app-photographer-list',
  templateUrl: './photographer-list.component.html',
  styleUrls: ['./photographer-list.component.css']
})
export class PhotographerListComponent implements OnInit {

  photographers: Array<UserModel>;

  constructor(
    private router: Router,
    private userService: UserService
  ) {
  }

  ngOnInit(): void {
    this.userService.getPhotographerList().subscribe(
      data => {
        this.photographers = data;
      }
    );
  }

  getPhotographerList(): Array<UserModel> {
    return this.photographers;
  }

  showPhotographerDetails(user) {
    user.posts = JSON.stringify(user.posts);
    this.router.navigate(['photographer-detail', user]);
  }

}
