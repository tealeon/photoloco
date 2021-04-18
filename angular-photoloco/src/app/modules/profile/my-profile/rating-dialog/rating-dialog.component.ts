import { Inject } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { forkJoin, Observable } from 'rxjs';
import { UserService } from 'src/app/core/services/user.service';

@Component({
  selector: 'app-rating-dialog',
  templateUrl: './rating-dialog.component.html',
  styleUrls: ['./rating-dialog.component.css']
})
export class RatingDialogComponent implements OnInit {

  users: { username: string, rating: number }[];

  constructor(
    @Inject(MAT_DIALOG_DATA) public usernames: string[],
    public dialogRef: MatDialogRef<RatingDialogComponent>,
    private userService: UserService
  ) {
    this.users = this.usernames.map(username => ({ username, rating: -1 }));
  }

  ngOnInit(): void {
    this.userService.getUserValue().subscribe(userValue => {
      this.userService.getRatedUser(userValue.instagramName).subscribe((users) => {
        console.log(users);
        for (let user of this.users) {
          const foundUser = users.find(aUser => aUser.user === user.username);
          if (foundUser != null) {
            user.rating = foundUser.rating;
          }
        }
      });
    });
  }

  rate(): void {
    this.userService.getUserValue().subscribe(userValue => {
      const requests: Observable<void>[] = [];
      for (let user of this.users) {
        requests.push(this.userService.rateUser(userValue.instagramName, user.username, user.rating));
      }

      forkJoin(requests).subscribe(() => {
        this.dialogRef.close();
      });
    });
  }
}
