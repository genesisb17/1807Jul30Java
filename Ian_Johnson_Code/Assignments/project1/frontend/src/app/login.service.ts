import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { User } from './user';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  constructor(private http: HttpClient) {}

  login(username: string, password: string): Observable<User> {
    return this.http
      .post<User>(
        environment.apiUrl + '/login',
        { username, password },
        { withCredentials: true }
      )
      .pipe(catchError(this.handleError));
  }

  logout(): Observable<void> {
    return this.http
      .post<void>(environment.apiUrl + '/logout', undefined, {
        withCredentials: true,
      })
      .pipe(catchError(this.handleError));
  }

  private handleError(error: HttpErrorResponse): Observable<never> {
    if (error.error instanceof ErrorEvent) {
      console.error(`An internal error occurred: ${error.error.message}`);
    } else if (error.status === 403) {
      return throwError('Incorrect username or password.');
    } else {
      console.error('Server returned an unexpected error:', error.error);
    }
    return throwError('An unexpected error occurred.');
  }
}