import {Component, OnInit} from '@angular/core';
import {LocationModel} from '../../../shared/models/location.model';
import {LocationService} from '../../../core/services/location.service';
import {Router} from '@angular/router';
import {HttpService} from '../../../core/services/http.service';

@Component({
  selector: 'app-location-list',
  templateUrl: './location-list.component.html',
  styleUrls: ['./location-list.component.css']
})
export class LocationListComponent implements OnInit {

  locations: Array<LocationModel>;

  constructor(
    private router: Router,
    private locationService: LocationService,
  ) {
  }

  ngOnInit(): void {
    this.locationService.getLocations().subscribe(
      data => {
        this.locations = data;
        console.log(data);
      }
    );
  }

  getAllLocations(): Array<LocationModel> {
    return this.locations;
  }

  showLocationDetail(location) {
    location.posts = JSON.stringify(location.posts);
    this.router.navigate(['location-detail', location]);
  }
}
