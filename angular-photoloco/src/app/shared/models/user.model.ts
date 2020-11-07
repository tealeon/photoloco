export class UserModel {

  id: number;
  firstName: string;
  lastName: string;
  eMail: string;
  city: string;
  country: string;
  isModel: boolean;
  isPhotographer: boolean;
  biography: string;
  // appointments: Array<Appointments>;
  // ratings: Array<Ratings>;
  // posts: Array<Post>;

  constructor(id: number, firstName: string, lastName: string, eMail: string, city: string, country: string, isModel: boolean, isPhotographer: boolean, biography: string) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.eMail = eMail;
    this.city = city;
    this.country = country;
    this.isModel = isModel;
    this.isPhotographer = isPhotographer;
    this.biography = biography;
  }

}
