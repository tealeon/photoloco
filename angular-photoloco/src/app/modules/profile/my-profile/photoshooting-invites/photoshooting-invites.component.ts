import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PhotoShootingInviteService } from 'src/app/core/services/photo-shooting-invite.service';
import { PhotoShootingInviteModel } from 'src/app/shared/models/photoShootingInvite.model';
import { UserModel } from 'src/app/shared/models/user.model';

@Component({
  selector: 'app-photoshooting-invites',
  templateUrl: './photoshooting-invites.component.html',
  styleUrls: ['./photoshooting-invites.component.css']
})
export class PhotoshootingInvitesComponent implements OnInit {

  @Input() user: UserModel;
  invites: PhotoShootingInviteModel[];

  constructor(private photoShootingInviteService: PhotoShootingInviteService, private router: Router) { }

  ngOnInit(): void {
    this.photoShootingInviteService.getInvitesOfUser(this.user.instagramName).subscribe((invites) => {
      this.invites = invites;
    });
  }

  reject(invite: PhotoShootingInviteModel): void {
    this.photoShootingInviteService.respondToInvite(invite.id, false).subscribe(() => this.reloadPage());
  }

  accept(invite: PhotoShootingInviteModel): void {
    this.photoShootingInviteService.respondToInvite(invite.id, true).subscribe(() => this.reloadPage());
  }

  private reloadPage(): void {
    this.router.routeReuseStrategy.shouldReuseRoute = () => false;
    this.router.onSameUrlNavigation = 'reload';
    this.router.navigate(['/my-profile']);
  }
}
