import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { CreateAccountComponent } from './components/create-account/create-account.component';
import { HomeComponent } from './components/home/home.component';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { AuthService } from './services/auth.service';
import { LandingComponent } from './components/landing/landing.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ReimbComponent } from './components/reimb/reimb.component';
import { AccountComponent } from './components/account/account.component';
import { DataFetchService } from './services/data-fetch.service';
import { ReimbStatusPipe } from './pipes/reimb-status.pipe';
import { ReimbTypePipe } from './pipes/reimb-type.pipe';
import { BankConnectComponent } from './bank-connect/bank-connect.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    CreateAccountComponent,
    HomeComponent,
    LandingComponent,
    NavbarComponent,
    ReimbComponent,
    AccountComponent,
    ReimbStatusPipe,
    ReimbTypePipe,
    BankConnectComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    CommonModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [AuthService, DataFetchService],
  bootstrap: [AppComponent]
})
export class AppModule { }
