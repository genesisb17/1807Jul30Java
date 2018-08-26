import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { AuthService } from './service/auth.service';
import { MainComponent } from './components/main/main.component';
import { CreateAccountComponent } from './components/create-account/create-account.component';


const appRoutes: Routes = [
  { path: 'login', component: LoginComponent},
  { path: 'home', component: HomeComponent},
  { path: 'create-account', component: CreateAccountComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginComponent,
    HomeComponent,
    MainComponent,
    CreateAccountComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(appRoutes),
    HttpClientModule
  ],
  /*[AuthService]*/
  providers: [AuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }
