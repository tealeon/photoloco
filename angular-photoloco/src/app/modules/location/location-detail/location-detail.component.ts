import {AfterViewInit, Component, OnInit} from '@angular/core';
import {ActivatedRoute, Params} from '@angular/router';
import {PostModel} from '../../../shared/models/post.model';
import {LocationModel} from '../../../shared/models/location.model';
import {HttpService} from '../../../core/services/http.service';
import * as L from 'leaflet';

@Component({
  selector: 'app-location-detail',
  templateUrl: './location-detail.component.html',
  styleUrls: ['./location-detail.component.css']
})
export class LocationDetailComponent implements OnInit {
  location: LocationModel;
  times: { [key: string]: any };
  sunrise: string;
  sunset: string;
  blueHour: string;
  zenit: string;
  goldenHour: string;
  blueHour2: string;
  private map2;

  constructor(
    private route: ActivatedRoute,
    private _http: HttpService) {
  }

  ngOnInit(): void {
    this.route.params.subscribe(
      (params: Params) => {
        this.location = new LocationModel(params.id, params.name, params.longitude, params.latitude, params.description, params.tag, params.imgUrl);
      }
    );

    console.log(this.location);
    this.getTimes(this.location.latitude, this.location.longitude);
  }

  viewInit(): void {

    console.log('init map');

    setTimeout(() => {
      this.initMap();

      const tiles = L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        maxZoom: 19,
        attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
      });

      tiles.addTo(this.map2);

      console.log('done!');
    }, 500);

    console.log('set marker');

    setTimeout(() => {
      const marker = L.marker([this.location.latitude, this.location.longitude]).addTo(this.map2);
      console.log('done!');
    }, 600);


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

  private initMap(): void {
    this.map2 = L.map('map2', {
      center: [this.location.latitude, this.location.longitude],
      zoom: 16
    });
  }

  test() {
    console.log('test');
  }


}
