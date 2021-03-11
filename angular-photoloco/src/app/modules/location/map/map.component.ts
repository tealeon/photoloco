import {AfterViewInit, Component, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import * as L from 'leaflet';
import {LocationService} from '../../../core/services/location.service';

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent implements AfterViewInit {


  private map;

  constructor(
    private locationService: LocationService
  ) {
  }

  ngAfterViewInit() {
    this.initMap();
    this.locationService.createMarkers(this.map);

    const tiles = L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      maxZoom: 19,
      attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
    });

    tiles.addTo(this.map);

    this.map.addEventListener('click', this.getCoords.bind(this));
  }

  private getCoords(ev) {
    const latlng = this.map.mouseEventToLatLng(ev.originalEvent);
    console.log(latlng.lat + ', ' + latlng.lng);
  }

  private initMap(): void {
    this.map = L.map('map', {
      center: [47.6965, 13.3457],
      zoom: 7
    });
  }

  updateMarkers(): void {
    this.locationService.createMarkers(this.map);
  }
}
