import {PostModel} from './post.model';

export class UserModel {

  id: number;
  username: string;
  firstName: string;
  lastName: string;
  imageUrl: string;
  eMail: string;
  city: string;
  country: string;
  isModel: boolean;
  isPhotographer: boolean;
  biography: string;
  posts: object;


  constructor(id: number, username: string, firstName: string, lastName: string, imageUrl: string, eMail: string, city: string, country: string, isModel: boolean, isPhotographer: boolean, biography: string, posts: string) {
    this.id = id;
    this.username = username;
    this.firstName = firstName;
    this.lastName = lastName;
    this.imageUrl = imageUrl;
    this.eMail = eMail;
    this.city = city;
    this.country = country;
    this.isModel = isModel;
    this.isPhotographer = isPhotographer;
    this.biography = biography;
    this.posts = JSON.parse(posts);
  }
}
