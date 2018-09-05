import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent } from './components/login/login.component';
// import { AccountComponent } from 'src/app/components/account/account.component';
// import { ReimbursementsComponent } from 'src/app/components/reimbursements/reimbursements.component';

export const routes: Routes = [
    { path: '', redirectTo: '/home', pathMatch: 'full' },
    // { path: 'account', component: AccountComponent },
    { path: 'login', component: LoginComponent },
    // { path: 'reimbursements', component: ReimbursementsComponent }
];

@NgModule({
    imports: [ RouterModule.forRoot(routes)],
    exports: [ RouterModule ]
})

export class AppRoutingModule {}
