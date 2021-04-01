import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Params, Router} from '@angular/router';
import {PostModel} from 'src/app/shared/models/post.model';
import {PostCommentModel} from '../../../shared/models/postComment.model';
import {PostService} from '../../../core/services/post.service';
import {FormBuilder, Validators} from '@angular/forms';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-post-detail',
  templateUrl: './post-detail.component.html',
  styleUrls: ['./post-detail.component.css']
})
export class PostDetailComponent implements OnInit {

  addressForm = this.fb.group({
    content: [null, Validators.required],
  });

  post;
  allPostComments: Array<PostCommentModel>;
  comments: Array<PostCommentModel>;
  url;

  constructor(
    private route: ActivatedRoute,
    private postService: PostService,
    private fb: FormBuilder,
    private http: HttpClient,
  ) {
  }

  ngOnInit(): void {
    this.route.params.subscribe(
      (params: Params) => {
        this.post = new PostModel(params.id, params.title, params.markdownContent, params.dateOfCreation, params.author, params.postComment);
        this.url = 'http://localhost:8080/post/' + this.post.id + '/comment';
      }
    );
    this.postService.getPostCommentsById(this.post.id).subscribe(
      data => {
        this.comments = data;
      }
    );
    this.postService.getPostComments().subscribe(
      data => {
        this.allPostComments = data;
      }
    );
  }

  getPostComments(): Array<PostCommentModel> {
    return this.allPostComments;
  }

  getPostCommentsById(): Array<PostCommentModel> {
    return this.comments;
  }

  onSubmit(data) {
    data.author_id = 9999;
    data.postRepliedTo_id = null;
    console.log(data);

    return this.http.post(this.url, data).subscribe(
      response => {
        console.log(response);
      }
    );
  }
}
