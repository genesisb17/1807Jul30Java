import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent } from '../login/login.component';
import { ReimbursementsComponent } from '../main/reimbursements/reimbursements.component';
import { MainComponent } from '../main/main.component';
import { AccountComponent } from '../main/account/account.component';
import { ReimbursementViewComponent } from '../main/reimbursements/reimbursement-view/reimbursement-view.component';
import { PageNotFoundComponent } from '../page-not-found/page-not-found.component';

const appRoutes: Routes = [
  { path: 'login', component: LoginComponent },
  {
    path: 'home',
    component: MainComponent,
    children: [
      {
        path: 'reimbursements',
        component: ReimbursementsComponent,
        children: [
          { path: ':status', component: ReimbursementViewComponent },
          { path: '', pathMatch: 'full', redirectTo: 'pending' },
        ],
      },
      { path: 'account', component: AccountComponent },
      { path: '', pathMatch: 'full', redirectTo: 'reimbursements' },
    ],
  },
  { path: '', pathMatch: 'full', redirectTo: '/login' },
  { path: '**', component: PageNotFoundComponent },
];

@NgModule({
  imports: [CommonModule, RouterModule.forRoot(appRoutes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
