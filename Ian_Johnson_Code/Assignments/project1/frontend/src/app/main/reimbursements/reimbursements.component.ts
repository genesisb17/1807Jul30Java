import { Component, OnInit } from '@angular/core';
import { Reimbursement } from '../../reimbursement';
import { UserService } from '../../user.service';
import { ReimbursementService } from '../../reimbursement.service';
import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-reimbursements',
  templateUrl: './reimbursements.component.html',
  styleUrls: ['./reimbursements.component.css'],
})
export class ReimbursementsComponent implements OnInit {
  reimbursements: Reimbursement[];

  constructor(
    public userService: UserService,
    public reimbursementService: ReimbursementService
  ) {}

  ngOnInit() {
    // Get all the reimbursements for the currently logged-in user.
    this.userService
      .getCurrentUser()
      .pipe(switchMap(user => this.reimbursementService.getByAuthor(user.id)))
      .subscribe(reimbursements => (this.reimbursements = reimbursements));
  }
}
