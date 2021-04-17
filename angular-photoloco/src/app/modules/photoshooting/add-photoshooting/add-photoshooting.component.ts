import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormControl, Validators } from "@angular/forms";
import { UserService } from "../../../core/services/user.service";
import { PhotoshootingService } from "../../../core/services/photoshooting.service";
import { formatDate } from "@angular/common";
import { PhotoShootingInviteService } from "../../../core/services/photo-shooting-invite.service";
import { PhotoShootingInviteModel } from "../../../shared/models/photoShootingInvite.model";
import { Router } from "@angular/router";

@Component({
  selector: "app-add-photoshooting",
  templateUrl: "./add-photoshooting.component.html",
  styleUrls: ["./add-photoshooting.component.css"],
})
export class AddPhotoshootingComponent implements OnInit {
  shootingForm = this.fb.group({
    title: [null, Validators.required],
    date: [null, Validators.required],
  });

  selectedUsers: string[] = [];
  selectedLocation: string;

  constructor(
    private userService: UserService,
    private fb: FormBuilder,
    private photoshootingService: PhotoshootingService,
    private photoShootingInviteService: PhotoShootingInviteService,
    private router: Router
  ) {}

  ngOnInit(): void {}

  displayFn(subject) {
    return subject ? subject.name : undefined;
  }

  updateUserList(users: string[]) {
    this.selectedUsers = users;
  }

  updateLocationList(locations: string) {
    this.selectedLocation = locations;
  }

  public listsValid(): boolean {
    return this.selectedLocation !== undefined && this.selectedUsers.length > 0;
  }

  onSubmit(): void {
    this.userService.getUserValue().subscribe((userValue) => {
      this.photoshootingService
        .submitPhotoshooting(
          this.shootingForm.value.title,
          formatDate(this.shootingForm.value.date, "yyyy-MM-dd", "en-US"),
          [userValue.instagramName],
          this.selectedLocation
        )
        .subscribe((photoShooting) => {
          this.selectedUsers.forEach((receiverInstagramName) => {
            this.photoShootingInviteService
              .sendInvite(
                photoShooting.id,
                new PhotoShootingInviteModel(
                  userValue.instagramName,
                  receiverInstagramName
                )
              )
              .subscribe(() => this.router.navigate(["my-profile"]));
          });
        });
    });
  }
}
