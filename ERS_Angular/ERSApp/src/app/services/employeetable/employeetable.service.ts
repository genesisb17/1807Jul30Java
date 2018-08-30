import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Reimbursement } from '../../model/reimbursement.model';

@Injectable({
  providedIn: 'root'
})

export class EmployeetableService {
  Reimbursement: Reimbursement;

  constructor(private http: HttpClient) { }

  getEmployeeTable(username: string): Observable<any> {
    return this.http.post<any>('http://localhost:8888/ERS_Project/employeetable.ng',
    {username: username});
  }
}
