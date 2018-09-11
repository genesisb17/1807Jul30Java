import { Component, OnInit, Input } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Reimbursement } from '../../objects/reimbursement.model';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { Router } from '@angular/router';
import { Employee } from '../../objects/employee.model';

@Component({
  selector: 'app-managerview',
  templateUrl: './managerview.component.html',
  styleUrls: ['./managerview.component.css']
})
export class ManagerviewComponent implements OnInit {

  emp_id: number;
  status_id: number;
  reimb_id: number;

  reimbs: Reimbursement[];
  emps: Employee[];

  constructor(private aroute: ActivatedRoute,
              private location: Location,
              private authService: AuthService,
              private router: Router) { }

  ngOnInit() { this.emp_id = this.getEmployeeId();
               this.getAllEmp();
               this.returnReimb();
  }

  getEmployeeId(): number {
    const emp_id = +this.aroute.snapshot.paramMap.get('servletEmpId');
    return emp_id;
  }

  returnReimb() {
    this.authService.getAllReimb().subscribe(
      data => {
        this.reimbs = data;
      }
    );
  }

  returnReimbSort(num: number) {
    this.authService.sortReimb(num).subscribe(
      data => {
        this.reimbs = data;
      }
    );
  }

  updateReimb(reid: number, status_id: number) {
    this.authService.updateReimb(reid, this.emp_id, status_id).subscribe();
    location.reload();
  }

  logout() {
    this.router.navigateByUrl('/login');
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
