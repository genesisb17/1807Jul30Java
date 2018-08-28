import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Employee } from '../models/employee.model';
import { Reimbursement } from '../models/reimbursement.model';
import { Observable } from 'rxjs';
//import { Observable, Subject, asapScheduler, pipe, of, from, interval, merge, fromEvent } from 'rxjs';

// import 'rxjs/Rx';

@Injectable()
export class ReimbursementService {

  constructor(private http: HttpClient) { }

  public handleError(error: Response){
    return Observable.throw(error.statusText);
  }

  // public getEmployees() {
  //   return this.http.get<Employee[]>('http://localhost:8888/Project1/employees');
  // }
    public getReimbursements() {
      return this.http.get<Reimbursement[]>('http://localhost:8888/Project1/reimbursements');
    }
}