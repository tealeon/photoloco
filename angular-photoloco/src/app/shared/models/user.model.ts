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
  posts: Array<PostModel>;


  constructor(id: number, username: string, firstName: string, lastName: string, imageUrl: string, eMail: string, city: string, country: string, isModel: boolean, isPhotographer: boolean, biography: string, posts: Array<PostModel>) {
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
    this.posts = posts;
  }
}
