import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent } from '../login/login.component';
import { ReimbursementsComponent } from '../main/reimbursements/reimbursements.component';
import { MainComponent } from '../main/main.component';
import { AccountComponent } from '../main/account/account.component';
import { ReimbursementViewComponent } from '../main/reimbursements/reimbursement-view/reimbursement-view.component';
import { PageNotFoundComponent } from '../page-not-found/page-not-found.component';
import { AdminReimbursementsComponent } from '../main/admin-reimbursements/admin-reimbursements.component';
import { AdminUsersComponent } from '../main/admin-users/admin-users.component';
import { AdminReimbursementViewComponent } from '../main/admin-reimbursements/admin-reimbursement-view/admin-reimbursement-view.component';

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
      {
        path: 'admin-reimbursements',
        component: AdminReimbursementsComponent,
        children: [
          { path: ':status', component: AdminReimbursementViewComponent },
          { path: '', pathMatch: 'full', redirectTo: 'pending' },
        ],
      },
      { path: 'admin-users', component: AdminUsersComponent },
      { path: '', pathMatch: 'full', redirectTo: 'reimbursements' },
    ],
  },
  { path: '', pathMatch: 'full', redirectTo: '/home/reimbursements/pending' },
  { path: '**', component: PageNotFoundComponent },
];

@NgModule({
  imports: [CommonModule, RouterModule.forRoot(appRoutes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
