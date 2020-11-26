export class PostModel {

  id: number;
  title: string;
  description: string;
  imgUrl: string;
  uploadDate: string;


  constructor(id: number, title: string, description: string, imgUrl: string, uploadDate: string) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.imgUrl = imgUrl;
    this.uploadDate = uploadDate;
  }
}
