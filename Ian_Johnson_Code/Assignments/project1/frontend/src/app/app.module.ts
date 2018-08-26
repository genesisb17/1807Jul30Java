import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { LoginService } from './login.service';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { AppRoutingModule } from './app-routing/app-routing.module';
import { UserService } from './user.service';
import { ReimbursementService } from './reimbursement.service';
import { MainComponent } from './main/main.component';
import { ReimbursementsComponent } from './main/reimbursements/reimbursements.component';
import { ReimbursementViewComponent } from './main/reimbursements/reimbursement-view/reimbursement-view.component';
import { AccountComponent } from './main/account/account.component';
import { NavbarComponent } from './main/navbar/navbar.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    MainComponent,
    NavbarComponent,
    ReimbursementsComponent,
    ReimbursementViewComponent,
    AccountComponent,
    PageNotFoundComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    NgbModule,
    AppRoutingModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
