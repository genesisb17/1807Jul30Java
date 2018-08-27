import { Component, OnInit, Input } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Reimbursement } from '../../objects/reimbursement.model';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-managerview',
  templateUrl: './managerview.component.html',
  styleUrls: ['./managerview.component.css']
})
export class ManagerviewComponent implements OnInit {

  emp_id: number;

  reimbs: Reimbursement[];
  constructor(private aroute: ActivatedRoute,
              private location: Location,
              private authService: AuthService) { }

  ngOnInit() { this.emp_id = this.getEmployeeId();
               this.reimbs = [new Reimbursement(1, 2, 3, 4, 'hello', 1, 1, 1, 1)];
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

}
