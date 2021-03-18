import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {FormBuilder, Validators} from '@angular/forms';

@Component({
  selector: 'app-create-post',
  templateUrl: './create-post.component.html',
  styleUrls: ['./create-post.component.css']
})
export class CreatePostComponent implements OnInit {

  addressForm = this.fb.group({
    title: [null, Validators.required],
    content: [null, Validators.required],
  });


  constructor(
    private http: HttpClient,
    private router: Router,
    private fb: FormBuilder,
  ) {
  }

  ngOnInit(): void {
  }

  onSubmit(value: any) {
    return null;
  }
}
