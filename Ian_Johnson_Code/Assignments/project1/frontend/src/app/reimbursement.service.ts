import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { Reimbursement } from './reimbursement';
import { environment } from '../environments/environment';
import { catchError } from 'rxjs/operators';
import { ReimbursementStatus } from './reimbursement-status.enum';

@Injectable({
  providedIn: 'root',
})
export class ReimbursementService {
  constructor(private http: HttpClient) {}

  getAll(status: ReimbursementStatus): Observable<Reimbursement[]> {
    const params = { status };
    return this.http
      .get<Reimbursement[]>(environment.apiUrl + '/reimbursements', {
        params,
        withCredentials: true,
      })
      .pipe(catchError(this.handleError));
  }

  getByAuthor(
    authorId: number,
    status: ReimbursementStatus
  ): Observable<Reimbursement[]> {
    const params = { author: authorId.toString(), status };
    return this.http
      .get<Reimbursement[]>(environment.apiUrl + '/reimbursements', {
        params,
        withCredentials: true,
      })
      .pipe(catchError(this.handleError));
  }

  resolve(id: number, approved: boolean) {
    const body = { id, approved };
    return this.http
      .post<void>(environment.apiUrl + '/resolve', body, {
        withCredentials: true,
      })
      .pipe(catchError(this.handleError));
  }

  submit(r: Reimbursement): Observable<Reimbursement> {
    return this.http
      .post<Reimbursement>(environment.apiUrl + '/reimbursements', r, {
        withCredentials: true,
      })
      .pipe(catchError(this.handleError));
  }

  private handleError(error: HttpErrorResponse): Observable<never> {
    if (error.error instanceof ErrorEvent) {
      console.error(`An internal error occurred: ${error.error.message}`);
    } else if (400 <= error.status && error.status < 500) {
      return throwError('Unauthorized (perhaps not logged in).');
    } else {
      console.error('Server returned an unexpected error:', error.error);
    }
    return throwError('An unexpected error occurred.');
  }
}
