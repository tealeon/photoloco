import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {map} from 'rxjs/operators';
import {BehaviorSubject, Observable} from 'rxjs';
import {UserModel} from '../../shared/models/user.model';
import {Router} from '@angular/router';
import {UserRatingModel} from 'src/app/shared/models/userRating.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private user;
  private loggedIn = new BehaviorSubject<boolean>(false);
  private userValue = new BehaviorSubject<UserModel>(null);

  constructor(private http: HttpClient, private router: Router) {
    const user: UserModel = JSON.parse(localStorage.getItem('user'));
    if (user != null) {
      this.login(user);
    }
  }

  isLoggedIn(): Observable<boolean> {
    return this.loggedIn.asObservable();
  }


  getUserValue(): Observable<UserModel> {
    return this.userValue.asObservable();
  }

  login(user: UserModel): void {
    this.http.post<UserModel>('http://localhost:8080/user/login', user).subscribe(value => {
      localStorage.setItem('user', JSON.stringify(user));
      this.user = user;
      this.loggedIn.next(true);
      this.userValue.next(value);
      console.log(value);
      this.router.navigate(['']);
    });
  }

  logout() {
    localStorage.removeItem('user');
    this.loggedIn.next(false);
    this.userValue.next(null);
    this.router.navigate(['']);
  }

  register(user: UserModel): void {
    this.http.post<UserModel>('http://localhost:8080/user', user).subscribe(value => {
      console.log(value);
      this.login(user);
    });
  }

  getUserByInstagramName(instagramName: string): Observable<UserModel> {
    const url = 'http://localhost:8080/user/insta/' + instagramName;
    return this.http.get<UserModel>(url);
  }

  getPhotographerList() {
    const url = 'http://localhost:8080/user/photographers';
    return this.http.get(url)
      .pipe(map(data => {
        const result = [];
        for (const key in data) {
          if (data.hasOwnProperty(key)) {
            result.push({...data[key]});
          }
        }
        return result;
      }));
  }

  getModelList() {
    const url = 'http://localhost:8080/user/models';
    return this.http.get(url)
      .pipe(map(data => {
        const result = [];
        for (const key in data) {
          if (data.hasOwnProperty(key)) {
            result.push({...data[key]});
          }
        }
        return result;
      }));
  }

  getAllUsers() {
    const url = 'http://localhost:8080/user';
    return this.http.get(url)
      .pipe(map(data => {
        const result = [];
        for (const key in data) {
          if (data.hasOwnProperty(key)) {
            result.push({...data[key]});
          }
        }
        return result;
      }));
  }

  addUser(user: UserModel): Observable<UserModel> {
    const url = 'http://localhost:8080/user';
    console.log(user);
    return this.http.post<UserModel>(url, user);
  }

  rateUser(instagramName: string, instagramNameRated: string, rating: number): Observable<void> {
    const url = 'http://localhost:8080/user/' + instagramName + '/' + instagramNameRated;
    return this.http.post<void>(url, rating);
  }

  getRatedUser(instagramName: string): Observable<UserRatingModel[]> {
    const url = 'http://localhost:8080/user/rating/' + instagramName;
    return this.http.get<UserRatingModel[]>(url);
  }
}
