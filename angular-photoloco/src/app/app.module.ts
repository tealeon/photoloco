import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
// @ts-ignore
import { CreateUserComponent } from './modules/user/components/create-user/create-user.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HomeComponent } from './modules/home/components/home/home.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HeaderComponent } from './core/header/header.component';
import { RouterModule, Routes } from '@angular/router';
import { PageNotFoundComponent } from './core/page-not-found/page-not-found.component';
import { PhotographerListComponent } from './modules/user/components/photographer-list/photographer-list.component';
import { MatCardModule } from '@angular/material/card';
import { TimesComponent } from './modules/times/times/times.component';
import { ModelListComponent } from './modules/user/components/model-list/model-list.component';
import { LocationListComponent } from './modules/location/location-list/location-list.component';
import { MapComponent } from './modules/location/map/map.component';
import { MatListModule } from '@angular/material/list';
import { UserDetailComponent } from './modules/user/components/user-detail/user-detail.component';
import { AddLocationComponent } from './modules/location/add-location/add-location.component';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatSelectModule } from '@angular/material/select';
import { MatRadioModule } from '@angular/material/radio';
import { AddPhotoshootingComponent } from './modules/photoshooting/add-photoshooting/add-photoshooting.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatChipsModule } from '@angular/material/chips';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { SelectUsersComponent } from './modules/photoshooting/add-photoshooting/select-users/select-users.component';
import { MatIconModule } from '@angular/material/icon';
import { SelectLocationComponent } from './modules/photoshooting/add-photoshooting/select-location/select-location.component';
import { MyProfileComponent } from './modules/profile/my-profile/my-profile.component';
import { PhotoshootingListComponent } from './modules/profile/my-profile/photoshooting-list/photoshooting-list.component';
import { ExploreComponent } from './modules/explore/explore/explore.component';
import { PostListComponent } from './modules/forum/post-list/post-list.component';
import { PostDetailComponent } from './modules/forum/post-detail/post-detail.component';
import { CreatePostComponent } from './modules/forum/create-post/create-post.component';
import { RegisterComponent } from './modules/registration/register/register.component';
import { LoginComponent } from './modules/registration/login/login.component';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { LocationDetailComponent } from './modules/location/location-detail/location-detail.component';
import {MatTabsModule} from '@angular/material/tabs';
import {AuthGuard} from './core/auth.guard';
import { PhotoshootingInvitesComponent } from './modules/profile/my-profile/photoshooting-invites/photoshooting-invites.component';

const appRoutes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'home', component: HomeComponent},
  {path: 'photographer-list', component: PhotographerListComponent, canActivate: [AuthGuard]},
  {path: 'model-list', component: ModelListComponent, canActivate: [AuthGuard]},
  {path: 'user-detail/:instagramName', component: UserDetailComponent, canActivate: [AuthGuard]},
  {path: 'times', component: TimesComponent, canActivate: [AuthGuard]},
  {path: 'location-list', component: LocationListComponent, canActivate: [AuthGuard]},
  {path: 'location-detail', component: LocationDetailComponent, canActivate: [AuthGuard]},
  {path: 'map', component: MapComponent, canActivate: [AuthGuard]},
  {path: 'add-location', component: AddLocationComponent, canActivate: [AuthGuard]},
  {path: 'post-list', component: PostListComponent, canActivate: [AuthGuard]},
  {path: 'post-detail', component: PostDetailComponent, canActivate: [AuthGuard]},
  {path: 'create-post', component: CreatePostComponent, canActivate: [AuthGuard]},
  {path: 'add-photoshooting', component: AddPhotoshootingComponent, canActivate: [AuthGuard]},
  {path: 'my-profile', component: MyProfileComponent, canActivate: [AuthGuard]},
  {path: 'explore', component: ExploreComponent, canActivate: [AuthGuard]},
  {path: 'register', component: RegisterComponent},
  {path: 'login', component: LoginComponent},
  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    PageNotFoundComponent,
    PhotographerListComponent,
    TimesComponent,
    ModelListComponent,
    LocationListComponent,
    MapComponent,
    UserDetailComponent,
    AddLocationComponent,
    AddPhotoshootingComponent,
    SelectUsersComponent,
    SelectUsersComponent,
    SelectLocationComponent,
    MyProfileComponent,
    PhotoshootingListComponent,
    ExploreComponent,
    PostListComponent,
    PostDetailComponent,
    CreatePostComponent,
    LoginComponent,
    RegisterComponent,
    LoginComponent,
    LocationDetailComponent,
    PhotoshootingInvitesComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes),
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatCardModule,
    MatListModule,
    MatInputModule,
    MatButtonModule,
    MatSelectModule,
    MatRadioModule,
    MatFormFieldModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatChipsModule,
    MatAutocompleteModule,
    MatIconModule,
    MatCheckboxModule,
    MatTabsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
