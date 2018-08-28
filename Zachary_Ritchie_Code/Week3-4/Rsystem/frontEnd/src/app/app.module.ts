import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { AuthService } from './service/auth.service';
import { CreateuserComponent } from './components/createuser/createuser.component';
import { AppRoutingModule } from './app-module-routing';
import { ReimbursmentsComponent } from './components/reimbursments/reimbursments.component';
import { ViewreimComponent } from './components/viewreim/viewreim.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginComponent,
    HomeComponent,
    CreateuserComponent,
    ReimbursmentsComponent,
    ViewreimComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  /*[AuthService]*/
  providers: [AuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }
