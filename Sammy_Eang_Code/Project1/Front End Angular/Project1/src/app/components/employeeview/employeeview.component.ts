import { Component, OnInit, Input } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Reimbursement } from '../../objects/reimbursement.model';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import {Router} from '@angular/router';
import { Employee } from '../../objects/employee.model';

@Component({
  selector: 'app-employeeview',
  templateUrl: './employeeview.component.html',
  styleUrls: ['./employeeview.component.css']
})
export class EmployeeviewComponent implements OnInit {

  emp_id: number;
  amount: number;
  description: string;
  type: number;

  reimbs: Reimbursement[];
  emps: Employee[];

  constructor(private aroute: ActivatedRoute,
              private location: Location,
              private authService: AuthService,
              private router: Router) { }

  ngOnInit() {
    this.emp_id = this.getEmployeeId();
    this.reimbs = [new Reimbursement(1, 2, 3, 4, 'hello', 1, 1, 1, 1)];
    this.returnReimb();
    this.getAllEmp();
  }

  getEmployeeId(): number {
    const emp_id = +this.aroute.snapshot.paramMap.get('servletEmpId');
    return emp_id;
  }

  returnReimb() {
    this.authService.getReimbById(this.emp_id).subscribe(
      data => {
        this.reimbs = data;
      }
    );
  }

  addNewReimb() {
    this.authService.submitNew(this.amount, this.description, this.emp_id, this.type).subscribe();
    location.reload();
  }

  logout() {
    this.router.navigateByUrl('/login');
  }

  returnReimbSort(num: number) {
    this.authService.sortEmpReimb(this.emp_id, num).subscribe(
      data => {
        this.reimbs = data;
      }
    );
  }

  getAllEmp() {
    this.authService.getAllEmp().subscribe(
      data => {
        this.emps = data;
      }
    );
  }

  findEmpName(id: number): string {
    if (this.emps.filter(g => g.emp_id === id).length === 0) {
      return '';
    }
    let fn = this.emps.filter(g => g.emp_id === id )[0].first_name;
    let ln = this.emps.filter(g => g.emp_id === id )[0].last_name;
    if (fn && ln) {
      return `${fn} ${ln}`;
    }
  }

  getType(id: number) {
    switch (id) {
      case 1:
        return 'Lodging';
      case 2:
        return 'Travel';
      case 3:
        return 'Food';
      case 4:
        return 'Certification';
      default:
        return 'Other';
    }
  }

  getStatus(id: number) {
    switch (id) {
      case 1:
        return 'Pending';
      case 2:
        return 'Approved';
      default:
        return 'Denied';
    }
  }
}

