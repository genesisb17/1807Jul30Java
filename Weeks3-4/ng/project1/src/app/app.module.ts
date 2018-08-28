import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';


import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { AuthService } from './services/auth.service';
import { LoginService } from './services/login.service';

import { HomeComponent } from './components/home/home.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { AppRoutingModule } from './app-routing.module';
import { ReimbursementService} from './services/reimbursement.service';
import { ReimbursementComponent } from './components/reimbursement/reimbursement.component';
import { NewEmployeeComponent } from './components/new-employee/new-employee.component';
import { LogoutComponent } from './components/logout/logout.component';

import { LandingComponent } from './components/landing/landing.component'
// import { RouterModule, Routes} from '@angular/router';
// import { EmployeeService } from './services/employee.service';
import { RegisterComponent } from './components/register/register.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
     
    NavbarComponent,
    HomeComponent,
    ReimbursementComponent,
    LoginComponent,
    NewEmployeeComponent,
    LogoutComponent,
    LandingComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule, // Gives us ngModel
    AppRoutingModule
  ],
  providers: [AuthService,
  ReimbursementService],
  bootstrap: [AppComponent]
})
export class AppModule { }
