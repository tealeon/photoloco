import { Component, OnInit } from '@angular/core';
import {HttpService} from '../../../core/services/http.service';

@Component({
  selector: 'app-times',
  templateUrl: './times.component.html',
  styleUrls: ['./times.component.css']
})
export class TimesComponent implements OnInit {

  times: { [key: string]: any };
  private lat: number;
  private lng: number;
  sunrise: string;
  sunset: string;
  blueHour;

  constructor(private _http: HttpService) {
  }

  ngOnInit(): void {

  }

  getTimes() {
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(position => {
        this.lat = position.coords.latitude;
        this.lng = position.coords.longitude;
        this._http.getTimes(this.lat, this.lng).subscribe(data => {
          this.times = data;
          this.sunrise = this.times?.results.sunrise;
          this.sunset = this.times?.results.sunset;
        });
      });
    } else {
      console.log('User not allow');
    }
  }

  private addTime(date: string, hours: number, minutes: number): string {
    const resultDate = new Date(date);
    resultDate.setHours(resultDate.getHours() + hours);
    resultDate.setMinutes(resultDate.getMinutes() + minutes);
    return resultDate.toString();
  }
}
