import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { EmployeeviewComponent } from './components/employeeview/employeeview.component';
import { ReimbAddComponent } from './components/reimb-add/reimb-add.component';
import { ManagerviewComponent } from './components/managerview/managerview.component';
import { AuthService } from './services/auth.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    EmployeeviewComponent,
    ReimbAddComponent,
    ManagerviewComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [AuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }
