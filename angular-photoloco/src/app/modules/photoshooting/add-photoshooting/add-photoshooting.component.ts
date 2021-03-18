import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, Validators} from '@angular/forms';
import { Observable } from 'rxjs';
import { map, startWith } from 'rxjs/operators';
import {UserService} from '../../../core/services/user.service';
import {PhotoshootingService} from '../../../core/services/photoshooting.service';
import {formatDate} from '@angular/common';

@Component({
  selector: 'app-add-photoshooting',
  templateUrl: './add-photoshooting.component.html',
  styleUrls: ['./add-photoshooting.component.css']
})
export class AddPhotoshootingComponent implements OnInit {

  shootingForm = this.fb.group({
    title: [null, Validators.required],
    date: [null, Validators.required]
  });

  selectedUsers: string[] = [];
  selectedLocation: string;

  constructor(
    private userService: UserService,
    private fb: FormBuilder,
    private photoshootingService: PhotoshootingService
  ) { }


  ngOnInit(): void {
  }

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
    console.log(this.shootingForm.valid, this.listsValid());
    if (this.shootingForm.valid && this.listsValid()) {
      this.photoshootingService.submitPhotoshooting(
        this.shootingForm.value.title,
        formatDate(this.shootingForm.value.date, 'yyyy-MM-dd', 'en-US'),
        this.selectedUsers,
        this.selectedLocation).subscribe(
        response => {
          console.log(response);
        }
      );
    }
  }
}
