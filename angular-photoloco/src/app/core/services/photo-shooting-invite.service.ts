import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {PhotoShootingInviteModel} from '../../shared/models/photoShootingInvite.model';

@Injectable({
  providedIn: 'root'
})
export class PhotoShootingInviteService {

  url = 'http://localhost:8080/invites';

  constructor(private http: HttpClient
  ) { }

  getInvitesOfUser(instagramName: string): Observable<PhotoShootingInviteModel[]> {
    return this.http.get<PhotoShootingInviteModel[]>(this.url + '/' + instagramName);
  }

  respondToInvite(id: number, response: boolean): Observable<void> {
    return this.http.post<void>(this.url + '/' + id + '/' + response, null);
  }

  sendInvite(photoShootingId: number, invite: PhotoShootingInviteModel): Observable<PhotoShootingInviteModel> {
    return this.http.post<PhotoShootingInviteModel>(this.url + '/' + photoShootingId, invite);
  }

}
