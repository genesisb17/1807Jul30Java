import { Component, OnInit } from '@angular/core';
import { Employee } from '../../models/employee.model';
import { Router } from '@angular/router';
import { EmployeeService } from '../../services/employee.service';


@Component({
  selector: 'app-new-employee',
  templateUrl: './new-employee.component.html',
  styleUrls: ['./new-employee.component.css']
})
export class NewEmployeeComponent implements OnInit {

  firstname: string;
  lastname: string;
  password: string;
  username: string;
  email: string;
  role_id: number;

  message: string;

  employee: Employee = new Employee();
  valid: boolean = false;
  registered: boolean = false;

  constructor(private eService: EmployeeService, private router: Router) {}

  ngOnInit() {
  }

  fullForm() {
    this.message="";
    console.log(`firstname: ${this.firstname} lastname: ${this.lastname} password: ${this.password} email: ${this.email}`);
    if (this.firstname != null && this.lastname != null && this.password != null && this.email != null && this.role_id != null) {
      this.register();
    }
    else {
      this.message = "Please fill out all fields!";
      this.valid = true;
    }
}
  setEmployee(){
    this.employee.first_name = this.firstname;
    this.employee.last_name = this.lastname;
    this.employee.emp_username = this.username;
    this.employee.emp_password = this.password;
    this.employee.email = this.email;
    this.employee.emp_role_id = this.role_id;
  }

  validateEmail() {
    this.message="";
    this.valid=false;
    console.log("blurred; in validate email");
    if (this.email != null) {
      let exists = this.eService.validateUsername(this.email)
        .subscribe(
        (exists) => {
          console.log("inside of subscribe printing exists" + exists);
          if (exists) {
           this.message = "Sorry, this email address is already being used. please try another";
            this.valid = true;
          }
        },
        error => console.log(error)
        )
    }
  }

  register() {
    this.setEmployee();
    console.log("adding employee" + this.firstname + this.lastname);
    this.eService.addEmployee(this.employee)
    .subscribe(
      (employee)=>this.message = `Congratulations ${employee.first_name}! Welcome to the app! Please log in with your credentials`
    );
    this.registered = true;

  }

  toLogin(){
    this.router.navigate([""]);
  }


}