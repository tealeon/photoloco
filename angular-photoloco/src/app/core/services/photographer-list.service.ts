import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PhotographerListService {

  url = 'http://localhost:8080/user/all/photographer';

  constructor(private http: HttpClient) { }

  getPhotographerList() {
    return this.http.get(this.url)
      .pipe(map( data => {
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
