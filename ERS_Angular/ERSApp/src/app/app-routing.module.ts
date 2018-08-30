import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { EmployeeComponent } from './components/employee/employee.component';
import { AdminComponent } from './components/admin/admin.component';


const routes: Routes = [
    {
        path: '',
        component: LoginComponent
    },
    {
        path: 'successful',
        component: EmployeeComponent
    },
    {
        path: 'admin',
        component: AdminComponent
    },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
