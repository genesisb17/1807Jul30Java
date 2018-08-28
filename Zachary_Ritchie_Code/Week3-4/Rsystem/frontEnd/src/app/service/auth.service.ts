import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs'; //../../../node_modules/
import { tap } from 'rxjs/operators'; //../../../node_modules/
import { Reim } from '../reim';
import { User } from '../user';

@Injectable({
  providedIn: 'root'
})

export class AuthService 
{
  public servletData: User;
  public reimData: Reim;
  public temp: User;

  constructor(private http: HttpClient) { }

  login(username: string, password: string): Observable<User> 
  {    
    return this.http.post<User>("http://localhost:8085/Rsystem/login", [username, password]).pipe(tap( data => {this.servletData = data}));
  }

  createAccount(username: string, password: string, firstname: string, lastname: string, email: string, role: number): Observable<User> 
  {
    return this.http.post<User>("http://localhost:8085/Rsystem/createAccount", [username, password, firstname, lastname, email, role]).pipe(tap(data => {this.temp = data}));
  }

  createReim(amount: number, description: string, author: number, typeId: number)
  {
    return this.http.put<Reim>("http://localhost:8085/Rsystem/employeeCreateReim", [amount, description, author, typeId])
  }

  employeeGetReim(id: number)
  {
    return this.http.post<User>("http://localhost:8085/Rsystem/employeeGetReim", [id])
  }

  managerGetReim()
  {
    return this.http.get<User>("http://localhost:8085/Rsystem/managerGetReim")
  }

  managerUpdateReim(id: number, resolver: number, status: number)
  {
    return this.http.put<User>("http://localhost:8085/Rsystem/managerUpdateReim", [id, resolver, status])
  }
}
