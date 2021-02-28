import {AfterViewInit, Component, OnInit} from '@angular/core';
import {FormBuilder, Validators} from '@angular/forms';
import {LocationService} from '../../../core/services/location.service';
import * as L from 'leaflet';
import {Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-add-location',
  templateUrl: './add-location.component.html',
  styleUrls: ['./add-location.component.css']
})
export class AddLocationComponent implements OnInit, AfterViewInit {
  addressForm = this.fb.group({
    name: [null, Validators.required],
    latitude: [null, Validators.required],
    longitude: [null, Validators.required],
    description: [null, Validators.required]
  });

  private map1;
  private url = 'http://localhost:8080/location';

  constructor(
    private fb: FormBuilder,
    private locationService: LocationService,
    private http: HttpClient
  ) {
  }

  onSubmit(data) {
    this.createNewLocation(data);
    alert('Thanks!');
  }

  ngOnInit(): void {
  }

  ngAfterViewInit(): void {
    this.initMap();

    const tiles = L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      maxZoom: 19,
      attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
    });

    tiles.addTo(this.map1);

    this.map1.addEventListener('click', this.getCoords.bind(this));
  }

  private getCoords(ev) {
    const latlng = this.map1.mouseEventToLatLng(ev.originalEvent);
    this.addressForm.controls.latitude.setValue(latlng.lat);
    this.addressForm.controls.longitude.setValue(latlng.lng);
    console.log(latlng.lat + ', ' + latlng.lng);
  }

  private initMap(): void {
    this.map1 = L.map('map1', {
      center: [47.6965, 13.3457],
      zoom: 7
    });
  }

  createNewLocation(data) {
    return this.http.post(this.url, data).subscribe(
      response => {
        console.log(response);
      }
    );
  }
}
