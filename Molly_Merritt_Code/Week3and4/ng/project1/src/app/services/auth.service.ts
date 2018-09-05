import { Injectable } from '@angular/core';
import { Observable, of } from '../../../node_modules/rxjs';
import { switchMap } from 'rxjs/operators';
import { User } from '../model/user.model';
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
  user: User;
  public currentId: number;

  constructor(private http: HttpClient) { }

  login(name: string, pw: string): Observable<any> {
    console.log('calling login method');
    const u = {
      username: name,
      password: pw
    };
    // this.username = name;
    // this.password = pw;
    // console.log(JSON.stringify(this.emp));
    // this.emp.emp_username = name;
    // this.emp.emp_password = pw;
    // console.log('emp_username = ' + this.emp.emp_username);

    // return this.http.post<any>('http://localhost:8085/project1v1/users', {username: username, password: password});
    // this.emp = this.validate(name, pw);

    // validate and use the result to assign values to user
    // let myUser = new Observable<User>();
    // myUser = this.validate(name, pw);
    // myUser = this.getUser(name);
    // this.user = {
    //   this.username = myUser.username
    // };
    // this.user = JSON.parse(JSON.stringify(myUser));
    // myUser.pipe(map(data => { this.user = data; }));
    // console.log(myUser);
    // console.log(this.user);
    return this.http.post<any>('http://localhost:8085/project1v1/login', JSON.stringify(u)); // pipe

  }

  // login(username: string, password: string): Observable<any> {
  //   return this.http.post<any>('http://localhost:8080/project1v1/login',
  //   {username: username, password: password});
  // }

  public getReimbursements() {
    return this.http.get<Reimbursement[]>('http://localhost:8085/project1v1/reimbursements');
  }

  public addReimbursement(amount: number, description: String, author: number, type_id: number) {
    return this.http.post<Reimbursement>('http://localhost:8085/project1v1/reimbursements',
      JSON.stringify([amount, description, author, type_id]));
  }

  public getUser(username: String): Observable<User> {
    return this.http.post<User>('http://localhost:4200/project1v1/users',
      JSON.stringify(username), httpOptions).pipe(tap(data => { this.user = data; }));
  }

  validate(username: string, password: string): Observable<User> {
    // console.log("in login service 'validate' with " + username)

    return this.getUser(username).pipe(switchMap(temp => {
      if (temp.user_id === 0) {
        return of(null); // creates new observable that does nothing except sent 1 null values
      } else {
        if (temp.password === password) {
          return of(temp); // returning user object of the newly logged in user
        } else {
          return of(null);
        }
      }
    })); // returning an observable

  }

  // registerUser(user: Employee) {
  //   const body: Employee = {
  //     username: user.username,
  //     password: user.password,
  //     email:  user.email,
  //     firstname: user.firstname,
  //     lastname: user.lastname,
  //     user_id: user.user_id
  //   };
  //   return this.http.post(this.baseUrl, body);
  // }

}
