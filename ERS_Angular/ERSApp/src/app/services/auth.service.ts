import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../model/user.model';

@Injectable({
  providedIn: 'root'
})

export class AuthService {
  user: User;
  userInfo: User;

  constructor(private http: HttpClient) {}

  login(username: string, password: string): Observable<any> {
    return this.http.post<any>('http://localhost:8888/ERS_Project/login.ng',
    {username: username, password: password});
  }
}
