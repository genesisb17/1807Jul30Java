import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Employee } from '../models/employee.model';
import { Reimbursement } from '../models/reimbursement.model';
import { HttpeeService } from './httpee.service';
import { Observable, of } from 'rxjs';

@Injectable()
export class ReimbursementService {

  constructor(private http: HttpClient, private httpService: HttpeeService) { }

  public handleError(error: Response){
    return Observable.throw(error.statusText);
  }

  public getAllReimbursements() {
    this.httpService.getReimbursements();
  }

}