import {UserModel} from './user.model';
import {PhotoshootingModel} from './photoshooting.model';

export class PhotoShootingInviteModel {
  sender: string;
  receiver: string;
  photoShooting: PhotoshootingModel;

  constructor(sender: string, receiver: string, photoShooting: PhotoshootingModel) {
    this.sender = sender;
    this.receiver = receiver;
    this.photoShooting = photoShooting;
  }
}
