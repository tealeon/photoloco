import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private http: HttpClient) { }

  getAllPosts() {
    const url = 'http://localhost:8080/post';
    return this.http.get(url)
      .pipe(map(data => {
        const result = [];
        for (const key in data) {
          if (data.hasOwnProperty(key)) {
            result.push({...data[key]});
          }
        }
        return result;
      }));
  }

  getPostComments() {
    const url = 'http://localhost:8080/postcomment';
    return this.http.get(url)
      .pipe(map(data => {
        const result = [];
        for (const key in data) {
          if (data.hasOwnProperty(key)) {
            result.push({...data[key]});
          }
        }
        return result;
      }));
  }

}
