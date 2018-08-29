import { Injectable } from '@angular/core';
import { Employee } from '../models/employee.model';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { EmployeeService } from './employee.service';
import { HttpClientModule } from '@angular/common/http'; 
import { HttpModule } from '@angular/http';

@Injectable()
export class LoginService {

  currentEmployee: Employee;
  API_URL = environment.apiUrl + "/employees";

  subscribers: Function[] = [];


  constructor(private http: HttpClient, private empService: EmployeeService) { }


  validate(username: string, password: string) {

    this.empService.getEmployees().subscribe(employees => {
      let filteredEmployees = employees.filter(employee => {
        if (employee.emp_username == username && employee.emp_password == password) return employee;
      })
      if (filteredEmployees.length > 0) {
        this.currentEmployee = filteredEmployees[0];
        this.subscribers.forEach(f => f())
      }
      else this.currentEmployee = null;
    });
  }

  subscribeToLogin(f: Function) {
    this.subscribers.push(f);
  }

  login(username:string){//, password:string){
    console.log("in login");
    this.empService.getEmployee(username).subscribe(
      employee=>{
        if(employee==null) {
          console.log(employee);
          return null;
        }
        else{ 
          return employee;
        }
      }

    )
  }
}