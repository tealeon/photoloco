export class PostCommentModel {

  id: number;
  content: string;
  author: object;
  postRepliedTo: object;
  post: object;
  replies: object;
  ratings: object;


  constructor(id: number, content: string, author: object, postRepliedTo: object, post: object, replies: object, ratings: object) {
    this.id = id;
    this.content = content;
    this.author = author;
    this.postRepliedTo = postRepliedTo;
    this.post = post;
    this.replies = replies;
    this.ratings = ratings;
  }
}
