export class PhotoShootingInviteModel {
  id: number;
  sender: string;
  receiver: string;
  dateOfPhotoShooting: string;
  location: string;
  title: string;

  constructor(sender: string, receiver: string) {
    this.sender = sender;
    this.receiver = receiver;
  }
}
