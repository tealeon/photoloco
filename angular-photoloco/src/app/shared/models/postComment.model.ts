export class PostCommentModel {

  id: number;
  content: string;
  author: string;
  postRepliedTo: object;
  post: object;
  replies: string;
  ratings: object;


  constructor(id: number, content: string, author: object, postRepliedTo: object, post: object, replies: object, ratings: object) {
    this.id = id;
    this.content = content;
    this.author = JSON.stringify(author);
    this.postRepliedTo = postRepliedTo;
    this.post = post;
    this.replies = JSON.stringify(replies);
    this.ratings = ratings;
  }
}
