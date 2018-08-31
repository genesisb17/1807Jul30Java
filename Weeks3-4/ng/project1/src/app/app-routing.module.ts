import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { ReimbursementComponent } from './components/reimbursement/reimbursement.component';
import { LandingComponent } from './components/landing/landing.component';
import { NewReimbursementComponent } from './components/new-reimbursement/new-reimbursement.component';
import { TransitionComponent } from './components/transition/transition.component';

export const routes: Routes = [
    { path: '', redirectTo: 'home', pathMatch: 'full' },
    // { path: 'home', component: HomeComponent },
    // { path: 'home', component: HomeComponent },
    { path: 'home', component: LandingComponent },
    { path: 'reimbursement', component: ReimbursementComponent },
    { path: 'newreimbursement', component: NewReimbursementComponent },
    { path: 'login', component: LoginComponent },
      {path: 'landing',component: LandingComponent}, //where I'll put the views for reg/manager reimbursements
      { path: 'transition',component: TransitionComponent},
];

@NgModule({
    imports: [ RouterModule.forRoot(routes)],
    exports: [ RouterModule ]
})

export class AppRoutingModule {}