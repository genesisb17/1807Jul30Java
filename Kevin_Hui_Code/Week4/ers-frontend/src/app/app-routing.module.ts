import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserLoginComponent } from './components/user-login/user-login.component';
import { ReimbViewComponent } from './components/reimb-view/reimb-view.component';


const routes: Routes = [
  { path: '', component: UserLoginComponent},
  { path: 'login', component: UserLoginComponent },
  { path: 'reimbView', component: ReimbViewComponent },
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {

  
}