import {PostCommentModel} from './postComment.model';

export class PostModel {

  id: number;
  title: string;
  markdownContent: string;
  dateOfCreation: string;
  author: string;
  postComment: PostCommentModel;

  constructor(id: number, title: string, markdownContent: string, dateOfCreation: string, author: string, postComment: PostCommentModel) {
    this.id = id;
    this.title = title;
    this.markdownContent = markdownContent;
    this.dateOfCreation = dateOfCreation;
    this.author = JSON.parse(author);
    this.postComment = postComment;
  }
}
