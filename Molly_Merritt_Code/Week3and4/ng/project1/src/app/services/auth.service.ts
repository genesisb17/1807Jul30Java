import { Injectable } from '@angular/core';
import { Observable, of } from '../../../node_modules/rxjs';
import { switchMap } from 'rxjs/operators';
import { Employee } from '../model/employee.model';
import { catchError, map, tap } from 'rxjs/operators';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Reimbursement } from '../model/reimbursement.model';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
 };

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private username: string;
  private password: string;
  emp: Employee;

  constructor(private http: HttpClient) { }

  login(name: string, pw: string): Observable<any> {
    console.log('calling login method');
    const user = {
      username: name,
      password: pw
    };
    this.username = name;
    this.password = pw;

    // return this.http.post<any>('http://localhost:8080/project1v1/users', {username: username, password: password});
    return this.http.post<any>('http://localhost:8085/project1v1/login', JSON.stringify(user)); // pipe

  }

  public getReimbursements() {
    return this.http.get<Reimbursement[]>('http://localhost:8085/project1v1/reimbursements');
  }

  public addReimbursement(amount: number, description: String, author: number, type_id: number) {
    return this.http.post<Reimbursement>('http://localhost:8085/project1v1/reimbursements',
      JSON.stringify([amount, description, author, type_id]), httpOptions);
  }

  public getEmployee(username: String): Observable<Employee> {
    return this.http.post<Employee>('http://localhost:4200/project1v1/users',
      JSON.stringify(username), httpOptions).pipe(tap(data => { this.emp = data; }));
  }

  validate(username: string, password: string): Observable<Employee> {
    // console.log("in login service 'validate' with " + username)

    return this.getEmployee(username).pipe(switchMap(temp => {
      if (temp.employee_id === 0) {
        return of(null); // creates new observable that does nothing except sent 1 null values
      } else {
        if (temp.emp_password === password) {
          return of(temp); // returning user object of the newly logged in user
        } else {
          return of(null);
        }
      }
    })); // returning an observable

  }

  // askForSomething() {
  //   return this.http.get<any>('http://localhost:8080/project1v1/users?pol=val');
  // }

  // getUser() {
  //   const user = {
  //     username: this.username,
  //     password: this.password
  //   };
  //   return this.http.post<any>('http://localhost:8085/project1v1/user', JSON.stringify(user));
  // }

  // logout() {
  //   this.username = null;
  //   this.password = null;
  // }

}
