import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { ReimbursementsComponent } from '../reimbursements/reimbursements.component';
import { MainComponent } from '../main.component';
import { AccountComponent } from '../account/account.component';

const mainRoutes: Routes = [
  {
    path: 'home',
    component: MainComponent,
    children: [
      { path: 'reimbursements', component: ReimbursementsComponent },
      { path: 'account', component: AccountComponent },
      { path: '', pathMatch: 'full', redirectTo: 'reimbursements' },
    ],
  },
];

@NgModule({
  imports: [CommonModule, RouterModule.forChild(mainRoutes)],
  exports: [RouterModule],
})
export class MainRoutingModule {}
