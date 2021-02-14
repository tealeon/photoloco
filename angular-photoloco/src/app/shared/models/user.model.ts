import {PostModel} from './post.model';

export class UserModel {

  id: number;
  username: string;
  firstName: string;
  lastName: string;
  imageUrl: string;
  email: string;
  city: string;
  country: string;
  isModel: boolean;
  isPhotographer: boolean;
  biography: string;
  instagramName: string;
  websiteUrl: string;
  posts: object;

  constructor(id: number, username: string, firstName: string, lastName: string, imageUrl: string, email: string, city: string, country: string, isModel: string, isPhotographer: string, biography: string, instagramName: string, websiteUrl: string, posts: object) {
    this.id = id;
    this.username = username;
    this.firstName = firstName;
    this.lastName = lastName;
    this.imageUrl = imageUrl;
    this.email = email;
    this.city = city;
    this.country = country;
    this.isModel = (isModel === 'true');
    this.isPhotographer = (isPhotographer === 'true');
    this.biography = biography;
    this.instagramName = instagramName;
    this.websiteUrl = websiteUrl;
    this.posts = posts;
  }
}
