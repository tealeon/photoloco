import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {CreateUserService} from "./create-user.service";

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit {
  registerForm: FormGroup;

  constructor(
    private userCreateService: CreateUserService) { }

  ngOnInit(): void {
    this.registerForm = new FormGroup({
      firstName: new FormControl(null, Validators.required),
      lastName: new FormControl(null, Validators.required),
      eMail: new FormControl(null, Validators.required),
      country: new FormControl(null, Validators.required),
      city: new FormControl(null, Validators.required)
    });
  }

  onSubmit(){
    this.userCreateService.createNewUser(this.registerForm.value);
  }

}
