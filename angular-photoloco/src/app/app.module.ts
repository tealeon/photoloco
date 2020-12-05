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
import { PhotographerDetailComponent } from './modules/user/components/photographer-detail/photographer-detail.component';
import { TimesComponent } from './modules/home/components/times/times.component';
import { ModelListComponent } from './modules/user/components/model-list/model-list.component';
import { ModelDetailComponent } from './modules/user/components/model-detail/model-detail.component';

const appRoutes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'home', component: HomeComponent},
  {path: 'photographer-list', component: PhotographerListComponent},
  {path: 'photographer-detail', component: PhotographerDetailComponent},
  {path: 'model-list', component: ModelListComponent},
  {path: 'model-detail', component: ModelDetailComponent},
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
    PhotographerDetailComponent,
    TimesComponent,
    ModelListComponent,
    ModelDetailComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes),
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatCardModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
