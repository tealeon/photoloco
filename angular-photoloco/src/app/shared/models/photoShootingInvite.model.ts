export class PhotoShootingInviteModel {
  sender: string;
  receiver: string;

  constructor(sender: string, receiver: string) {
    this.sender = sender;
    this.receiver = receiver;
  }
}
