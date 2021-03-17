import {Component, ElementRef, EventEmitter, OnInit, Output, ViewChild} from '@angular/core';
import {COMMA, ENTER} from '@angular/cdk/keycodes';
import {FormControl} from '@angular/forms';
import {Observable} from 'rxjs';
import {MatAutocomplete, MatAutocompleteSelectedEvent} from '@angular/material/autocomplete';
import {map, startWith} from 'rxjs/operators';
import {LocationService} from '../../../../core/services/location.service';

@Component({
  selector: 'app-select-location',
  templateUrl: './select-location.component.html',
  styleUrls: ['./select-location.component.css']
})
export class SelectLocationComponent implements OnInit {

  visible = true;
  selectable = true;
  removable = true;
  separatorKeysCodes: number[] = [ENTER, COMMA];
  locationCtrl = new FormControl();
  filteredLocation: Observable<string[]>;
  locations: string[] = [];
  allLocations: string[] = [];

  @Output() updateLocationList = new EventEmitter<string>();

  @ViewChild('locationInput') locationInput: ElementRef<HTMLInputElement>;
  @ViewChild('auto') matAutocomplete: MatAutocomplete;

  constructor(
    private locationService: LocationService
  ) {
    this.showFilteredLocations();
  }

  remove(location: string): void {
    const index = this.locations.indexOf(location);

    if (index >= 0) {
      this.locations.splice(index, 1);
      this.allLocations.push(location);
      this.sendToParent();
    }
  }

  private _filter(value: string): string[] {
    const filterValue = value.toLowerCase();

    return this.allLocations.filter(location => location.toLowerCase().indexOf(filterValue) === 0);
  }

  showFilteredLocations() {
    this.filteredLocation = this.locationCtrl.valueChanges.pipe(
      startWith(null),
      map((location: string | null) => location ? this._filter(location) : this.allLocations.slice()));
  }

  selected(event: MatAutocompleteSelectedEvent): void {
    const value = event.option.viewValue;
    if (this.locations.length > 0) {
      this.allLocations.push(this.locations.pop());
    }
    this.locations.push(value);
    this.locationInput.nativeElement.value = '';
    this.locationCtrl.setValue(null);
    this.allLocations.splice(this.allLocations.indexOf(value), 1);
    this.sendToParent();
  }

  ngOnInit(): void {
    this.locationService.getLocations().subscribe(value => {
      this.allLocations = value.map(location => location.name);
    });
  }

  sendToParent(): void {
    this.updateLocationList.emit(this.locations[0]);
  }
}
