import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {map} from 'rxjs/operators';
import * as L from 'leaflet';

import { icon, Marker } from 'leaflet';
const iconRetinaUrl = 'assets/marker-icon-2x.png';
const iconUrl = 'assets/marker-icon.png';
const shadowUrl = 'assets/marker-shadow.png';
const iconDefault = icon({
  iconRetinaUrl,
  iconUrl,
  shadowUrl,
  iconSize: [25, 41],
  iconAnchor: [12, 41],
  popupAnchor: [1, -34],
  tooltipAnchor: [16, -28],
  shadowSize: [41, 41]
});
Marker.prototype.options.icon = iconDefault;

@Injectable({
  providedIn: 'root'
})
export class LocationService {

  constructor(private http: HttpClient) {
  }

  getLocations() {
    const url = 'http://localhost:8080/location';
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

  createMarkers(locationMap: L.map) {
    const url = 'http://localhost:8080/location';

    this.http.get(url).subscribe((res: any) => {
      console.log(res);
      for (const c of res) {
        const lat = c.latitude;
        const lon = c.longitude;

        console.log('lat:' + lat + ', lon:' + lon);
        const marker = L.marker([lon, lat]).addTo(locationMap);
        marker.bindPopup(this.createMarkerPopUp(c));
      }
    });
  }

  createMarkerPopUp(data: any): string {
    return '' +
      '<div style="font-weight: bold">' + data.name + '</div>' +
      '<div>' + data.description + '</div>';
  }

}
