import { Injectable } from '@angular/core';
import { Employee } from '../models/employee.model';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { EmployeeService } from './employee.service';
import { HttpClientModule } from '@angular/common/http'; 
import { HttpModule } from '@angular/http';
import { HttpeeService } from './httpee.service';
import { Observable, of } from 'rxjs';

import { switchMap } from 'rxjs/operators';

@Injectable()
export class LoginService {

  currentEmployee: Employee;
  // API_URL = environment.apiUrl + "/Project1";

  subscribers: Function[] = [];


  constructor(private http: HttpClient, private httpService: HttpeeService) { }


  validate(username: string, password: string): Observable<Employee> {
    console.log("in login service 'validate' with " + username)
    
    return this.httpService.getEmployee(username).pipe(switchMap(temp => {
      if(temp.employee_id == 0){
        return of(null); //creates new observable that does nothing except sent 1 null values
      } else{
        if(temp.emp_password == password){
          return of(temp); //returning user object of the newly logged in user
        } else{
          return of(null);
        }
      }
    })) //returning an observable
    
  }

  subscribeToLogin(f: Function) {
    this.subscribers.push(f);
  }

  login(username: String){//, password:string){
    console.log("in service login");
    this.httpService.getEmployee(username).subscribe(
      currentEmployee=>{
        if(currentEmployee==null) {
          console.log("hello" + currentEmployee);
          return null;
        }
        else{ 
          return currentEmployee;
        }
      }

    )
  }
}