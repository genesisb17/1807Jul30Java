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

  user: User;
  emps: Reimbursement[];

  private amount: number;
  private description: string;
  private requestType: number;
  private requestTypeStr: string;

  constructor(private authService: AuthService) { }

  ngOnInit() {
    this.authService.getCurrentUser()
    .subscribe(data => { this.authService.user = data;
    if (this.authService.user !== null) {
      this.user = this.authService.user;
      this.displayEmpTable();
    } });
  }

  displayEmpTable() {
    this.authService.empTable(this.authService.user.username)
    .subscribe(data => { this.emps = data;
    });

  }

  submit() {
    this.requestType = +this.requestTypeStr;
    console.log(this.requestType);
    if (this.amount < 0) {
      alert('Please enter a non-negative number in the Reimbursement Amount textbox.');
    } else if (typeof this.amount === 'string') {
      alert('Please enter numbers only in the Reimbursement Amount textbox.');
    } else if (this.requestType === 0) {
      alert('You cannot enter a request amount of $0.00.');
    } else if (this.requestType === NaN) {
      alert('Please select a request type.');
    } else {
      this.authService.submit(this.amount, this.description,
         this.requestType, this.authService.user.username)
         .subscribe(data => {
          this.displayEmpTable();
      });
    }
  }
}
