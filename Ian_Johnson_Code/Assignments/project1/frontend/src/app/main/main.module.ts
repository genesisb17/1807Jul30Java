import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MainComponent } from './main.component';
import { NavbarComponent } from './navbar/navbar.component';
import { MainRoutingModule } from './main-routing/main-routing.module';
import { ReimbursementsComponent } from './reimbursements/reimbursements.component';
import { AccountComponent } from './account/account.component';

@NgModule({
  imports: [CommonModule, MainRoutingModule],
  declarations: [MainComponent, NavbarComponent, ReimbursementsComponent, AccountComponent],
  bootstrap: [MainComponent],
})
export class MainModule {}
