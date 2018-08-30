import { Injectable } from '@angular/core';
import { HttpClient } from '../../../node_modules/@angular/common/http';
import { Observable } from '../../../node_modules/rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  login(name: string, pw: string): Observable<any> {
    console.log('calling login method');
    const user = {
      username: name,
      password: pw
    };

    // return this.http.post<any>('http://localhost:8080/project1v1/users', {username: username, password: password});
    return this.http.post<any>('http://localhost:8085/project1v1/login', JSON.stringify(user));

  }

  // askForSomething() {
  //   return this.http.get<any>('http://localhost:8080/project1v1/users?pol=val');
  // }

}
