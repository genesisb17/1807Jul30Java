import { LoginComponent } from './component/login/login.component';
import { UserinfoComponent } from './component/userinfo/userinfo.component';
import { ReimbursementsComponent } from './component/reimbursements/reimbursements.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateComponent } from './component/create/create.component';
import { NewReqComponent } from './component/new-req/new-req.component';


export const routes: Routes = [
    { path: '', redirectTo: 'login', pathMatch: 'full' },
    { path: 'login', component: LoginComponent },
    { path: 'userinfo', component: UserinfoComponent },
    { path: 'reimbursements', component: ReimbursementsComponent },
    { path: 'create', component: CreateComponent},
    { path: 'newReim', component: NewReqComponent}
];

@NgModule({
    imports: [ RouterModule.forRoot(routes)],
    exports: [ RouterModule ]
})
export class AppRoutingModule {}