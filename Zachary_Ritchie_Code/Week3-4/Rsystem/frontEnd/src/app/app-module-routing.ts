import { NgModule } from "../../node_modules/@angular/core";
import { RouterModule, Routes } from "../../node_modules/@angular/router";
import { HomeComponent } from "./components/home/home.component";
import { LoginComponent } from './components/login/login.component';
import { CreateuserComponent } from './components/createuser/createuser.component';
import { ReimbursmentsComponent } from './components/reimbursments/reimbursments.component';
import { ViewreimComponent } from './components/viewreim/viewreim.component';


export const routes: Routes = [
    { path: 'login', component: LoginComponent},
  { path: 'home', component: HomeComponent},
  { path: 'createuser', component: CreateuserComponent},
  { path: 'createReimbursements', component: ReimbursmentsComponent},  
  { path: 'reimbursements', component: ViewreimComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule {}