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
   * Creates a new user.
   *
   * @param user the user information of the new user
   * @param password the password of the new user
   */
  create(user: User, password: string): Observable<User> {
    return this.http.post<User>(
      environment.apiUrl + '/users',
      { user, password },
      { withCredentials: true }
    );
  }

  /**
   * Gets a single user by ID.
   *
   * @param id the ID of the user to get
   */
  getById(id: number): Observable<User> {
    const params = { id: id.toString() };
    return this.http
      .get<User>(environment.apiUrl + '/users', {
        params,
        withCredentials: true,
      })
      .pipe(catchError(this.handleError));
  }

  /**
   * Gets a single user by username.
   *
   * @param username the username of the user to get
   */
  getByUsername(username: string): Observable<User> {
    const params = { username };
    return this.http
      .get<User>(environment.apiUrl + '/users', {
        params,
        withCredentials: true,
      })
      .pipe(catchError(this.handleError));
  }

  /**
   * Gets a list of all users in the system.
   */
  getAll(): Observable<User[]> {
    return this.http
      .get<User[]>(environment.apiUrl + '/users', { withCredentials: true })
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
    } else if (400 <= error.status && error.status < 500) {
      return throwError(error.error);
    } else {
      console.error('Server returned an unexpected error:', error.error);
    }
    return throwError('An unexpected error occurred.');
  }
}
