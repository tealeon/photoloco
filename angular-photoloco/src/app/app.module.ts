import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
// @ts-ignore
import { CreateUserComponent } from './modules/user/components/create-user/create-user.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HomeComponent } from './modules/home/components/home/home.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HeaderComponent } from './core/header/header.component';
import {RouterModule, Routes} from '@angular/router';
import { PageNotFoundComponent } from './core/page-not-found/page-not-found.component';
import { PhotographerListComponent } from './modules/user/components/photographer-list/photographer-list.component';
import {MatCardModule} from '@angular/material/card';
import { TimesComponent } from './modules/times/times/times.component';
import { ModelListComponent } from './modules/user/components/model-list/model-list.component';
import { LocationListComponent } from './modules/location/location-list/location-list.component';
import { MapComponent } from './modules/location/map/map.component';
import {MatListModule} from '@angular/material/list';
import { UserDetailComponent } from './modules/user/components/user-detail/user-detail.component';
import { AddLocationComponent } from './modules/location/add-location/add-location.component';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatSelectModule } from '@angular/material/select';
import { MatRadioModule } from '@angular/material/radio';

const appRoutes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'home', component: HomeComponent},
  {path: 'photographer-list', component: PhotographerListComponent},
  {path: 'model-list', component: ModelListComponent},
  {path: 'user-detail', component: UserDetailComponent},
  {path: 'times', component: TimesComponent},
  {path: 'location-list', component: LocationListComponent},
  {path: 'map', component: MapComponent},
  {path: 'add-location', component: AddLocationComponent},
  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    CreateUserComponent,
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
    MatRadioModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
