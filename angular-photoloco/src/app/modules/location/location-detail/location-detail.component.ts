import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Params} from '@angular/router';
import {PostModel} from '../../../shared/models/post.model';
import {LocationModel} from '../../../shared/models/location.model';
import {HttpService} from '../../../core/services/http.service';

@Component({
  selector: 'app-location-detail',
  templateUrl: './location-detail.component.html',
  styleUrls: ['./location-detail.component.css']
})
export class LocationDetailComponent implements OnInit {
  private location: LocationModel;
  times: { [key: string]: any };
  sunrise: string;
  sunset: string;
  blueHour: string;
  zenit: string;
  goldenHour: string;
  blueHour2: string;

  constructor(
    private route: ActivatedRoute,
    private _http: HttpService) {
  }

  ngOnInit(): void {
    this.route.params.subscribe(
      (params: Params) => {
        this.location = new LocationModel(params.id, params.name, params.longitude, params.latitude, params.description, params.tag);
      }
    );

    this.getTimes(this.location.latitude, this.location.longitude);
  }

  getTimes(lat, lng) {
    this._http.getTimes(lat, lng).subscribe(data => {
      this.times = data;
      this.sunrise = this.times?.results.sunrise;
      this.sunset = this.times?.results.sunset;
      this.blueHour = this.addTime(this.sunrise, -1, 0);
      this.goldenHour = this.addTime(this.sunset, -1, 0);
      this.blueHour2 = this.addTime(this.sunset, 1, 30);
      this.zenit = this.addTime(this.sunrise, 6, 0);
    });
  }

  private addTime(date: string, hours: number, minutes: number): string {
    const resultDate = new Date(date);
    resultDate.setHours(resultDate.getHours() + hours);
    resultDate.setMinutes(resultDate.getMinutes() + minutes);
    return resultDate.toString();
  }

}
