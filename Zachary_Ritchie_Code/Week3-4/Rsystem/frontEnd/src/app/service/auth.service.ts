import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs'; //../../../node_modules/
import { User } from '../user';
import { LoginComponent } from '../components/login/login.component';

@Injectable({
  providedIn: 'root'
})
export class AuthService 
{
  public servletData: User;
  constructor(private http: HttpClient) { }

  login(username: string, password: string): Observable<User> 
  {    
    return this.http.post<User>("http://localhost:8085/Rsystem/login", [username, password]);
  }
}
