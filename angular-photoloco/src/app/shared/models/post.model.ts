export class PostModel {

  id: number;
  title: string;
  description: string;
  imageUrl: string;
  uploadDate: string;


  constructor(id: number, title: string, description: string, imageUrl: string, uploadDate: string) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.imageUrl = imageUrl;
    this.uploadDate = uploadDate;
  }
}
