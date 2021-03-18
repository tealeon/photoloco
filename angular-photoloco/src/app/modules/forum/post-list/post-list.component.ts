import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {PostService} from '../../../core/services/post.service';
import {PostModel} from '../../../shared/models/post.model';
import {UserModel} from '../../../shared/models/user.model';

@Component({
  selector: 'app-post-list',
  templateUrl: './post-list.component.html',
  styleUrls: ['./post-list.component.css']
})
export class PostListComponent implements OnInit {

  posts: Array<PostModel>;

  constructor(private router: Router,
              private postService: PostService) { }

  ngOnInit(): void {
    this.postService.getAllPosts().subscribe(
      data => {
        this.posts = data;
      }
    );

    for (let i = 0; i < this.posts.length; i++) {
      this.posts[i].author = JSON.stringify(this.posts[i].author);
    }
  }

  getAllPosts(): Array<PostModel> {
    return this.posts;
  }

  showPostDetails(post) {
    post.author = JSON.stringify(post.author);
    post.postComment = JSON.stringify(post.postComment);
    this.router.navigate(['post-detail', post]);
  }
}
