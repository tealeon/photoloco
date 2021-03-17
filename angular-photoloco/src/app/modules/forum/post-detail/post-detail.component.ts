import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Params} from '@angular/router';
import { PostModel } from 'src/app/shared/models/post.model';
import {PostCommentModel} from '../../../shared/models/postComment.model';
import {PostService} from '../../../core/services/post.service';

@Component({
  selector: 'app-post-detail',
  templateUrl: './post-detail.component.html',
  styleUrls: ['./post-detail.component.css']
})
export class PostDetailComponent implements OnInit {

  post;
  postcomments: Array<PostCommentModel>;

  constructor(
    private route: ActivatedRoute,
    private postService: PostService
  ) {
  }

  ngOnInit(): void {
    this.postService.getPostComments().subscribe(
      data => {
        this.postcomments = data;
      }
    );

    this.route.params.subscribe(
      (params: Params) => {
        this.post = new PostModel(params.id, params.title, params.markdownContent, params.dateOfCreation, params.author, params.postComment);
      }
    );
  }

  getPostComments(): Array<PostCommentModel> {
    return this.postcomments;
  }
}
