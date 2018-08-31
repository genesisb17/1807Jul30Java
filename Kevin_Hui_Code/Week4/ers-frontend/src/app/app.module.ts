import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

import { AppComponent } from './app.component';
import { UserLoginComponent } from './components/user-login/user-login.component';
import { AppRoutingModule } from './/app-routing.module';
import { AuthService } from './services/auth.service';
import { ReimbViewComponent } from './components/reimb-view/reimb-view.component';


@NgModule({
  declarations: [AppComponent, UserLoginComponent, ReimbViewComponent],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [AuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }
