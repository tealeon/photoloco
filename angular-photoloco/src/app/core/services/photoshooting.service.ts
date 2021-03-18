import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from "rxjs";
import {PhotoshootingModel} from "../../shared/models/photoshooting.model";

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

  getAllPhotoshootings(): Observable<PhotoshootingModel[]> {
    return this.http.get<PhotoshootingModel[]>(this.url);
  }

  getAllPhotoshootingsOfUser(username: string): Observable<PhotoshootingModel[]> {
    return this.http.get<PhotoshootingModel[]>(this.url + '/' + username);
  }
}
