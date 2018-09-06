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
    return this.http.post<any>('http://localhost:8085/project1v1/login', JSON.stringify(u));
  }

  signup(un: string, pw: string, fn: string, ln: string, em: string, rid: number): Observable<any> {
    console.log('calling signup method');
    const u = {
      username: un,
      password: pw,
      firstname: fn,
      lastname: ln,
      email: em,
      role_id: rid
    };
    return this.http.post<any>('http://localhost:8085/project1v1/signup', JSON.stringify(u));
  }

  public getReimbursements() {
    return this.http.get<Reimbursement[]>('http://localhost:8085/project1v1/reimbursements');
  }

  public getReimbursementsByUser(id: number) {
    console.log('in getReimbursementsByUser http method');
    return this.http.post<Reimbursement[]>('http://localhost:8085/project1v1/userreimbs', {authorId: id});
  }

  public addReimbursement(amount: number, description: String, authorId: number, type_id: number) {
    return this.http.post<Reimbursement>('http://localhost:8085/project1v1/reimbursements',
      {amount: amount, description: description, authorId: authorId, typeId: type_id});
  }

  public updateReimbursement(reimbId: number, resolverId: number, statusId: number) {
    return this.http.post<Reimbursement>('http://localhost:8085/project1v1/updatereimb',
      {reimbId: reimbId, resolverId: resolverId, statusId: statusId});
  }

  public getUser(username: String): Observable<User> {
    return this.http.post<User>('http://localhost:4200/project1v1/users',
      JSON.stringify(username), httpOptions).pipe(tap(data => { this.user = data; }));
  }

  validate(username: string, password: string): Observable<User> {
    // console.log("in login service 'validate' with " + username)

    return this.getUser(username).pipe(switchMap(temp => {
      if (temp.id === 0) {
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

}
