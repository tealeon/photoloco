import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class CreateUserService {

  url = 'http://localhost:8080/user/insert';

  constructor(private http: HttpClient) { }

  createNewUser(data) {
    return this.http.post(this.url, data).subscribe(
      response => {
        console.log(response);
      }
    );
  }
}
