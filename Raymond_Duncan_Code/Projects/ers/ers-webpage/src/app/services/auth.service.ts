import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../components/models/user';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  login(name: string, pw: string): Observable<any> {
    const user = {
      username: name,
      password: pw
    };
    return this.http.post<User>('http://localhost:8081/ers/login', JSON.stringify(user));
  }

  createAccount(username: String, password: String, firstname: String, lastname: String, email: String,
     creator: Number, companyRole: String) {
    const user = {
      username: username,
      password: password,
      firstname: firstname,
      lastname: lastname,
      email: email,
      companyRole: companyRole,
      creator: creator
    };
    return this.http.post<User>('http://localhost:8081/ers/createAccount', JSON.stringify(user));
  }
}
