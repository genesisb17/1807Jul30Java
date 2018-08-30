import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth/auth.service';
import { User } from '../../model/user.model';
import { Reimbursement } from '../../model/reimbursement.model';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  isAdmin: boolean;
  user: User;
  emps: Reimbursement[];

  private amount: number;
  private description: string;
  private requestTypeStr: string;
  private requestType: number;

  constructor(private authService: AuthService) { }

  ngOnInit() {
    this.user = this.authService.user;
     if (this.authService.user.username === 'admin') {
       this.isAdmin = true;
     }
     this.displayEmpTable();
  }

  displayEmpTable() {
    this.authService.empTable(this.authService.user.username)
    .subscribe(data => { this.emps = data;
    });

  }

  submit() {
    this.requestType = +this.requestTypeStr;

    if (this.amount < 0) {
      alert('Please no negative numbers.');
    } else if (this.requestType === null) {
      alert('Please select a request type.');
    } else {
      this.authService.submit(this.amount, this.description,
         this.requestType, this.authService.user.username)
         .subscribe(data => {this.authService.user = data;

        });
    }
    this.displayEmpTable();
  }
}
