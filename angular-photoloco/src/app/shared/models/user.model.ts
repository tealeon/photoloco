import {PostModel} from './post.model';
import {PhotoshootingModel} from './photoshooting.model';

export class UserModel {

  id: number;
  username: string;
  firstName: string;
  lastName: string;
  imageUrl: string;
  email: string;
  city: string;
  country: string;
  model: boolean;
  photographer: boolean;
  biography: string;
  instagramName: string;
  websiteUrl: string;
  posts: object;
  photoShootingsInvolvedIn: PhotoshootingModel[];
  password: string;
  rating: number;

  constructor(id: number, username: string, firstName: string, lastName: string, imageUrl: string, email: string, city: string, country: string, isModel: string, isPhotographer: string, biography: string, instagramName: string, websiteUrl: string, posts: object, photoShootingsInvolvedIn: PhotoshootingModel[], password: string) {
    this.id = id;
    this.username = username;
    this.firstName = firstName;
    this.lastName = lastName;
    this.imageUrl = imageUrl;
    this.email = email;
    this.city = city;
    this.country = country;
    this.model = (isModel === 'true');
    this.photographer = (isPhotographer === 'true');
    this.biography = biography;
    this.instagramName = instagramName;
    this.websiteUrl = websiteUrl;
    this.posts = posts;
    this.photoShootingsInvolvedIn = photoShootingsInvolvedIn;
    this.password = password;
  }
}
