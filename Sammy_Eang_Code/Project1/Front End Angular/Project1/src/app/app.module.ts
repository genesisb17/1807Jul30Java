import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { EmployeeviewComponent } from './components/employeeview/employeeview.component';
import { ManagerviewComponent } from './components/managerview/managerview.component';
import { AuthService } from './services/auth.service';
import { DataService } from './services/data.service';
import { AppRoutingModule } from './/app-routing.module';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    EmployeeviewComponent,
    ManagerviewComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [AuthService, DataService],
  bootstrap: [AppComponent]
})

export class AppModule { }
