import { Injectable } from '@angular/core';
import { Employee } from '../models/employee.model';
import { environment } from '../../environments/environment';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Reimbursement } from '../models/reimbursement.model';
import { Observable } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

const API_URL = environment.apiUrl + "/Project1";
const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};
@Injectable({
  providedIn: 'root'
})
export class HttpeeService {

  constructor(private http: HttpClient) { }

  temp: Employee;

  public getEmployees(): Observable<Employee[]> {
    return this.http.get<Employee[]>(API_URL+"/allsaveemployee");
  }

  public getEmployee(username: String): Observable<Employee>{
    return this.http.post<Employee>(API_URL+"/findupdateemployee",JSON.stringify(username),httpOptions).pipe(tap(data => {this.temp = data}));
  }

  public getReimbursements(){
    return this.http.get<Reimbursement[]>(API_URL+"/allsavereimbursement");
  }

  public getReimbursement(reimb: Reimbursement){
    return this.http.post<Reimbursement[]>(API_URL+"/findupdatereimbursement",reimb,httpOptions);
  }

  public addEmployee(emp: Employee){
    return this.http.post<Employee>(API_URL+"/allsaveemployee", emp, httpOptions);
  }

  public addReimbursement(amount: number, description: String, author: number, type_id: number){
    return this.http.post<Reimbursement>(API_URL+"/allsavereimbursement", JSON.stringify([amount,description,author,type_id]), httpOptions);
  }
  
  public resolveReimbursement(reimb_id: number, employee_id: number, status_id: number){
    return this.http.post<Reimbursement>(API_URL+"/resolve", [reimb_id,employee_id,status_id], httpOptions);
  }
}
