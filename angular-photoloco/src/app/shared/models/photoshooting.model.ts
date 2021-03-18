import {LocationModel} from './location.model';

export interface PhotoshootingModel {
  id: number;
  title: string;
  dateOfPhotoShooting: Date;
  userInvolved: string [];
  location: LocationModel;
}
