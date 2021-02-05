export class LocationModel {

  id: number;
  name: string;
  longitude: number;
  latitude: number;
  locations: object;

  constructor(id: number, name: string, longitude: number, latitude: number, locations: object) {
    this.id = id;
    this.name = name;
    this.longitude = longitude;
    this.latitude = latitude;
    this.locations = locations;
  }
}
