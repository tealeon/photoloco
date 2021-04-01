export class LocationModel {

  id: number;
  name: string;
  longitude: number;
  latitude: number;
  description: string;
  tag: string;
  imgUrl: string;

  constructor(id: number, name: string, longitude: number, latitude: number, description: string, tag: string, imgUrl: string) {
    this.id = id;
    this.name = name;
    this.longitude = longitude;
    this.latitude = latitude;
    this.description = description;
    this.tag = tag;
    this.imgUrl = imgUrl;
  }
}
