import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) {}

  login(username: string, password: string): Observable<any> {
    return this.http.post<any>("http://localhost:8085/ers/login.ng", {username: username, password: password});
  }
  getReimbursementsByUser(username: string): Observable<any> {
    return this.http.post<any>("http://localhost:8085/ers/getReimbursementsByUser.ng", {username: username});
  }
  // getReimbursement(empID: number): Observable<any> {
  //   return this.http.post<any>("http://localhost:8085/ers/getReimbursement.ng", {empID: empID});
  // }
  // submitReimbursement(author: number, amount: number, typeid: number, description: string): Observable<any> {
  //   return this.http.post<any>("http://localhost:8085/ers/submitReimbursement.ng", {author: author, amount: amount, typeID: typeid, description: description});
  // }
  // approveReimbursement(rbID: number, resolver: number): Observable<any> {
  //   return this.http.post<any>("http://localhost:8085/ers/pproveReimbursement.ng", {rbID: rbID, resolver: resolver });
  // }
  // denyReimbursement(rbID: number, resolver: number): Observable<any> {
  //   return this.http.post<any>("http://localhost:8085/ers/denyReimbursement.ng", {rbID: rbID, resolver: resolver });
  // }
  // getReimbursementOrder(empID: number, lastname: string): Observable<any> {
  //   return this.http.post<any>("http://localhost:8085/ers/getReimbursementOrder.ng", {empID: empID, lastname: lastname });
  // }
  // getAllReimbursementOrder(description: string): Observable<any> {
  //   return this.http.post<any>("http://localhost:8085/ers/getAllReimbursementOrder.ng", {description: description});
  // }
  getAllEmployee(): Observable<any> {
    return this.http.post<any>("http://localhost:8085/ers/getAllEmployee.ng", {});
  }
}
