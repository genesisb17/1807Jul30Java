import { Component, OnInit, Input } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Reimbursement } from '../../objects/reimbursement.model';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-employeeview',
  templateUrl: './employeeview.component.html',
  styleUrls: ['./employeeview.component.css']
})
export class EmployeeviewComponent implements OnInit {

  servletData: any;

  emp_id: number;

  reimbs: Reimbursement[];

  showVar = false;
  toggleReimbAddView() {
    this.showVar = !this.showVar;
  }

  constructor(private route: ActivatedRoute,
              private location: Location,
              private authService: AuthService) { }

  ngOnInit() {
    this.emp_id = this.getEmployeeId();
    this.reimbs = [new Reimbursement(1, 2, 3, 4, 'hello', 1, 1, 1, 1)];
    this.returnReimb();
  }

  getEmployeeId(): number {
    const emp_id = +this.route.snapshot.paramMap.get('servletEmpId');
    return emp_id;
  }

  returnReimb() {
    this.authService.getReimbById(this.emp_id).subscribe(
      data => {
        this.reimbs = data;
      }
    );
  }
}

