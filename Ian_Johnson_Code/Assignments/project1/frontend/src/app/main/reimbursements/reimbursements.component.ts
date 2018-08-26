import { Component, OnInit } from '@angular/core';
import { Reimbursement } from '../../reimbursement';
import { UserService } from '../../user.service';
import { ReimbursementService } from '../../reimbursement.service';
import { switchMap } from 'rxjs/operators';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-reimbursements',
  templateUrl: './reimbursements.component.html',
  styleUrls: ['./reimbursements.component.css'],
})
export class ReimbursementsComponent implements OnInit {
  reimbursements: Reimbursement[];
  selectedStatus: string;

  constructor(
    private userService: UserService,
    private reimbursementService: ReimbursementService,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    // Get all the reimbursements for the currently logged-in user.
    this.userService
      .getCurrentUser()
      .pipe(switchMap(user => this.reimbursementService.getByAuthor(user.id)))
      .subscribe(reimbursements => (this.reimbursements = reimbursements));
    // Subscribe to the child's routes so that we can choose the right tab based
    // on the selected status.
    this.route.firstChild.paramMap.subscribe(params => {
      this.selectedStatus = params.get('status');
    });
  }
}
