import { Component } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {UserModel} from '../../../shared/models/user.model';
import {UserService} from '../../../core/services/user.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent {
  registerForm: FormGroup;

  addressForm = this.fb.group({
    username: new FormControl(null, Validators.required),
    instagramName: new FormControl(null, Validators.required),
    firstName: [null, Validators.required],
    lastName: [null, Validators.required],
    email: new FormControl( null, Validators.email),
    websiteUrl: new FormControl(null, Validators.required),
    country: new FormControl(null, Validators.required),
    city: new FormControl(null, Validators.required),
    biography: new FormControl(null, Validators.required),
    photographer: [false],
    model: [false],
    imageUrl: new FormControl(null, Validators.required),
    password: new FormControl(null, Validators.required)
  });

  constructor(private fb: FormBuilder, private userService: UserService, private router: Router) {}

  onSubmit() {
    this.registerForm = this.addressForm;
    const user = this.registerForm.value as UserModel;
    this.router.navigate(['']);
    this.userService.register(user);
  }
}
