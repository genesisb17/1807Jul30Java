import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';


import { AppComponent } from './app.component';
import { LoginComponent } from './component/login/login.component';
import {AuthService} from './service/auth.service';
import { CreateComponent } from './component/create/create.component';
import { UserinfoComponent } from './component/userinfo/userinfo.component';
import { MenuComponent } from './component/menu/menu.component';
import { ReimbursementsComponent } from './component/reimbursements/reimbursements.component';
import { AppRoutingModule } from './app-routing.module';
import { CreateAcctComponent } from './component/create-acct/create-acct.component';
import { NewReqComponent } from './component/new-req/new-req.component';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    CreateComponent,
    UserinfoComponent,
    MenuComponent,
    ReimbursementsComponent,
    CreateAcctComponent,
    NewReqComponent,
  ],
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
