import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../../model/user.model';
import { Reimbursement } from '../../model/reimbursement.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  user: User;
  emps: Reimbursement[];

  constructor(private http: HttpClient) { }

  login(username: string, password: string): Observable<any> {
    return this.http.post<any>('http://localhost:8888/ERS_Project/login.ng',
    {username: username, password: password});
  }

  empTable(username: string): Observable<any> {
    return this.http.post<Reimbursement[]>('http://localhost:8888/ERS_Project/emptable.ng',
    {username: username});
  }

  submit(amount: number, description: string, requestType: number, username: string): Observable<any> {
    return this.http.post<any>('http://localhost:8888/ERS_Project/submitrequest.ng',
      {amount: amount, description: description, requestType: requestType, username: username});
  }
}
