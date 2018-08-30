import { Injectable } from '@angular/core';
import { Employee } from '../models/employee.model';
import { environment } from '../../environments/environment';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { error } from 'selenium-webdriver';

const API_URL = environment.apiUrl + "/employees";
const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class EmployeeService {

  constructor(private http: HttpClient) { }

  // public getEmployees(){
  //   return this.http.get<Employee[]>(API_URL);
  // }

  // public addEmployee(user: Employee){
  // return this.http.post<Employee>(API_URL, user, httpOptions);
  // }

  // public validateUsername(username: string){
  //   console.log("validating user with username" + username);
  //   return this.http.post<string>(API_URL+"/username", username, httpOptions);
  // }

  // public getEmployee(username: string){
  //   console.log("getting user with username"+ username );
  //   return this.http.post<string>(API_URL+"/byusername",username, httpOptions );
  // }

}