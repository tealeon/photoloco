export class LocationModel {

  id: number;
  name: string;
  longitude: number;
  latitude: number;

  constructor(id: number, name: string, longitude: number, latitude: number) {
    this.id = id;
    this.name = name;
    this.longitude = longitude;
    this.latitude = latitude;
  }
}
