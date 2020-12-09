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
          console.log(this.times?.results.sunrise);
        });
      });
    } else {
      console.log('User not allow');
    }
  }
}
