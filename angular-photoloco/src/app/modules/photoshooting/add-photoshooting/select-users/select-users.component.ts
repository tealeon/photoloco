import {Component, ElementRef, EventEmitter, OnInit, Output, ViewChild} from '@angular/core';
import {COMMA, ENTER} from '@angular/cdk/keycodes';
import {FormControl} from '@angular/forms';
import {Observable} from 'rxjs';
import {MatAutocomplete, MatAutocompleteSelectedEvent} from '@angular/material/autocomplete';
import {MatChipInputEvent} from '@angular/material/chips';
import {map, startWith} from 'rxjs/operators';
import {UserService} from '../../../../core/services/user.service';

@Component({
  selector: 'app-select-users',
  templateUrl: './select-users.component.html',
  styleUrls: ['./select-users.component.css']
})
export class SelectUsersComponent implements OnInit {

  visible = true;
  selectable = true;
  removable = true;
  separatorKeysCodes: number[] = [ENTER, COMMA];
  userCtrl = new FormControl();
  filteredUsers: Observable<string[]>;
  users: string[] = [];
  allUsers: string[] = [];

  @Output() updateUserList = new EventEmitter<string []>();

  @ViewChild('userInput') userInput: ElementRef<HTMLInputElement>;
  @ViewChild('auto') matAutocomplete: MatAutocomplete;

  constructor(
    private userService: UserService
  ) {
    this.filteredUsers = this.userCtrl.valueChanges.pipe(
      startWith(null),
      map((user: string | null) => user ? this._filter(user) : this.allUsers.slice()));
  }

  remove(user: string): void {
    const index = this.users.indexOf(user);

    if (index >= 0) {
      this.users.splice(index, 1);
      this.allUsers.push(user);
      this.sendToParent();
    }
  }

  private _filter(value: string): string[] {
    const filterValue = value.toLowerCase();

    return this.allUsers.filter(user => user.toLowerCase().indexOf(filterValue) === 0);
  }

  showFilteredUsers() {
    this.filteredUsers = this.userCtrl.valueChanges.pipe(
      startWith(null),
      map((user: string | null) => user ? this._filter(user) : this.allUsers.slice()));
  }

  selected(event: MatAutocompleteSelectedEvent): void {
    const value = event.option.viewValue;
    this.users.push(value);
    this.userInput.nativeElement.value = '';
    this.userCtrl.setValue(null);
    this.allUsers.splice(this.allUsers.indexOf(value), 1);
    this.sendToParent();
  }

  ngOnInit(): void {
    this.userService.getAllUsers().subscribe(value => {
      this.allUsers = value.map(user => user.instagramName);
    });
  }

  sendToParent(): void {
    this.updateUserList.emit(this.users);
  }
}
