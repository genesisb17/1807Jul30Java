import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private userId: number;
  private roleId: number;

  constructor(private http: HttpClient) {}

  setUserData(userId: number, roleId: number){
    this.userId = userId;
    this.roleId = roleId;
  }

  getUserData(): number[] {
    let temp: number[] = [this.userId, this.roleId];
    return temp;
  }

  clearData(): void {
    this.userId = undefined;
    this.roleId = undefined;
  }

  login(username: string, password: string): Observable<any> {
    return this.http.post<any>("http://localhost:8085/ers/login.ng", {username: username, password: password});
  }
  getAllReimbursements(): Observable<any> {
    return this.http.post<any>("http://localhost:8085/ers/getAllReimbursements.ng", {});
  }
  getReimbursementsByUserId(userId: number): Observable<any> {
    return this.http.post<any>("http://localhost:8085/ers/getReimbursementsByUserId.ng", {userId: userId});
  }
  addReimbursement(amount: number, description: string, typeId: number, authorId: number): Observable<any> {
    return this.http.post<any>("http://localhost:8085/ers/addReimbursement.ng", {amount: amount, description: description, typeId: typeId, authorId: authorId});
  }
  approveReimbursement(rbID: number, resolver: number): Observable<any> {
    return this.http.post<any>("http://localhost:8085/ers/aproveReimbursement.ng", {rbID: rbID, resolver: resolver });
  }
  denyReimbursement(rbID: number, resolver: number): Observable<any> {
    return this.http.post<any>("http://localhost:8085/ers/denyReimbursement.ng", {rbID: rbID, resolver: resolver });
  }
  getAllReimbType(): Observable<any> {
    return this.http.post<any>("http://localhost:8085/ers/getAllReimbType.ng", {});
  }
}
