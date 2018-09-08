import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private userId: number;
  private roleId: number;
  private name: string;

  constructor(private http: HttpClient) {}

  setUserData(userId: number, roleId: number, name: string){
    this.userId = userId;
    this.roleId = roleId;
    this.name = name;
  }

  getUserData(): any[] {
    let temp: any[] = [this.userId, this.roleId, this.name];
    return temp;
  }

  clearData(): void {
    this.userId = undefined;
    this.roleId = undefined;
    this.name = undefined;
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
  approveReimbursement(reimbId: number, resolverId: number): Observable<any> {
    return this.http.post<any>("http://localhost:8085/ers/approveReimbursement.ng", {reimbId: reimbId, resolverId: resolverId});
  }
  denyReimbursement(reimbId: number, resolverId: number): Observable<any> {
    return this.http.post<any>("http://localhost:8085/ers/denyReimbursement.ng", {reimbId: reimbId, resolverId: resolverId});
  }
  getAllReimbType(): Observable<any> {
    return this.http.post<any>("http://localhost:8085/ers/getAllReimbType.ng", {});
  }
}
