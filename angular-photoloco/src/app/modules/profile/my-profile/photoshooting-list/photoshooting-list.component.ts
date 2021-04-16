import {Component, Input, OnInit} from '@angular/core';
import {PhotoshootingService} from '../../../../core/services/photoshooting.service';
import {PhotoshootingModel} from '../../../../shared/models/photoshooting.model';
import {Router} from '@angular/router';

@Component({
  selector: 'app-photoshooting-list',
  templateUrl: './photoshooting-list.component.html',
  styleUrls: ['./photoshooting-list.component.css']
})
export class PhotoshootingListComponent implements OnInit {

  photoshootings: PhotoshootingModel[] = [];
  @Input() user;

  constructor(
    private photoshootingService: PhotoshootingService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.photoshootingService.getAllPhotoshootingsOfUser(this.user.username).subscribe(value => {
      this.photoshootings = value;
      console.log(value);
    });
  }

  navigateToUserDetail(instagramName: string): void {
    this.router.navigate(['user-detail', instagramName]);
  }
}
