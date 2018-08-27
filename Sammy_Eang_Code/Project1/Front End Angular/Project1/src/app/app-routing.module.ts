import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { EmployeeviewComponent } from './components/employeeview/employeeview.component';
import { ManagerviewComponent } from './components/managerview/managerview.component';

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'eview/:servletEmpId', component: EmployeeviewComponent },
  { path: 'mview/:servletEmpId', component: ManagerviewComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
