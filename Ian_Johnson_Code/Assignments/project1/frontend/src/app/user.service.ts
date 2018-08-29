import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';

import { User } from './user';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor(private http: HttpClient) {}

  /**
   * Gets a single user by ID.
   *
   * @param id the ID of the user to get
   */
  get(id: number): Observable<User> {
    const params = { id: id.toString() };
    return this.http
      .get<User>(environment.apiUrl + '/users', {
        params,
        withCredentials: true,
      })
      .pipe(catchError(this.handleError));
  }

  /**
   * Gets the currently logged-in user.
   */
  getCurrentUser(): Observable<User> {
    return this.http
      .get<User>(environment.apiUrl + '/login', { withCredentials: true })
      .pipe(catchError(this.handleError));
  }

  /**
   * Updates a user using the given user data.
   *
   * @param user a user object with the updated data
   */
  update(user: User): Observable<User> {
    return this.http
      .put<User>(environment.apiUrl + '/users', user, { withCredentials: true })
      .pipe(catchError(this.handleError));
  }

  /**
   * Updates a user's password.
   *
   * @param username the user's username
   * @param password the user's password
   */
  updatePassword(username: string, password: string): Observable<void> {
    return this.http
      .post<void>(
        environment.apiUrl + '/change-password',
        { username, password },
        { withCredentials: true }
      )
      .pipe(catchError(this.handleError));
  }

  private handleError(error: HttpErrorResponse): Observable<never> {
    if (error.error instanceof ErrorEvent) {
      console.error(`An internal error occurred: ${error.error.message}`);
    } else if (error.status === 403) {
      return throwError('Unauthorized (perhaps not logged in).');
    } else {
      console.error('Server returned an unexpected error:', error.error);
    }
    return throwError('An unexpected error occurred.');
  }
}
