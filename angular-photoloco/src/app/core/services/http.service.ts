import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private http: HttpClient) { }

  getTimes(lat, lng) {
    const p = 'https://api.sunrise-sunset.org/json?lat=' + lat + '&lng=' + lng;
    return this.http.get(p);
  }
}
