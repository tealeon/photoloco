import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Params} from '@angular/router';
import { PostModel } from 'src/app/shared/models/post.model';
import {PostCommentModel} from '../../../shared/models/postComment.model';

@Component({
  selector: 'app-post-detail',
  templateUrl: './post-detail.component.html',
  styleUrls: ['./post-detail.component.css']
})
export class PostDetailComponent implements OnInit {

  post;

  constructor(
    private route: ActivatedRoute
  ) {
  }

  ngOnInit(): void {
    this.route.params.subscribe(
      (params: Params) => {
        this.post = new PostModel(params.id, params.title, params.markdownContent, params.dateOfCreation, params.author, params.postComment);
      }
    );
  }
}
