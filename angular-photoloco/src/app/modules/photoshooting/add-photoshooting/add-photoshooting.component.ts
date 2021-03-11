import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Observable } from 'rxjs';
import { map, startWith } from 'rxjs/operators';

@Component({
  selector: 'app-add-photoshooting',
  templateUrl: './add-photoshooting.component.html',
  styleUrls: ['./add-photoshooting.component.css']
})
export class AddPhotoshootingComponent implements OnInit {

  options: string[] = ['Angular', 'React', 'Vue'];

  objectOptions = [
    { name: 'Leonn'},
    { name: 'Franciss'},
    { name: 'Franciss'},
    { name: 'Loo'},
    { name: 'MΛЯIΛ'},
    { name: 'Hopee'}
  ];

  constructor() { }

  ngOnInit(): void {
  }

  displayFn(subject) {
    return subject ? subject.name : undefined;
  }

}
