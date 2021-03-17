import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PhotoshootingService {

  url = 'http://localhost:8080/photoshootings';

  constructor(
    private http: HttpClient
  ) { }

  submitPhotoshooting(title: string, date: string, users: string[], location: string) {
    return this.http.post(this.url, {
      title,
      dateOfPhotoShooting: date,
      userInvolved: users,
      location: {name: location}
    });
  }
}
