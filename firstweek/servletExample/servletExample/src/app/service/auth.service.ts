import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Reimbursements } from '../model/reimbursements';
import { User } from '../model/user';
import { NewUser } from '../model/new-user';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  reim: Observable<Reimbursements[]>;
  users: Observable<User[]>;
  user: User;
  
  isLoggedIn: boolean;
  constructor(private http: HttpClient) { }
  
  createNewUser(newUser): Observable<NewUser> {
   return this.http.post<NewUser>("http://localhost:8081/servletExample/create.ng", newUser);
  }
  
  login(username: string, password: string): Observable<any> {
    
    return this.http.post<User>("http://localhost:8081/servletExample/login.ng", { username: username, password: password }, { withCredentials: true });
  }


 

  reimbursements(): Observable<Reimbursements[]> {
    this.reim = this.http.post<Reimbursements[]>("http://localhost:8081/servletExample/reimbursements.ng", {}, { withCredentials: true });
    return this.http.post<Reimbursements[]>("http://localhost:8081/servletExample/reimbursements.ng", {}, { withCredentials: true });
  }
  allReimbursements(): Observable<Reimbursements[]> {
    this.reim = this.http.post<Reimbursements[]>("http://localhost:8081/servletExample/allreimbursements.ng", {}, { withCredentials: true });
    return this.http.post<Reimbursements[]>("http://localhost:8081/servletExample/allreimbursements.ng", {}, { withCredentials: true });
  }

  logout() {
    this.isLoggedIn = false;
    this.http.get("http://localhost:8081/servletExample/logout.ng").subscribe(
      data => {
        console.log(data);
      });
  }

  getAllUsers(): Observable<User[]> {
    this.users = this.http.post<User[]>("http://localhost:8081/servletExample/allusers.ng", {}, { withCredentials: true });
    return this.http.post<User[]>("http://localhost:8081/servletExample/allusers.ng", {}, { withCredentials: true });
  }

  createNewRequest(newReq): Observable<Reimbursements> {
    return this.http.post<Reimbursements>("http://localhost:8081/servletExample/newReimbursement.ng", newReq);
   }

   updateRequest(rid: number, status: string): Observable<any> {
    return this.http.post<any>("http://localhost:8081/servletExample/updateReimbursement.ng", {rid: rid, status: status});
   }


}
