import { Component, OnInit } from '@angular/core';
import { Reimbursement } from '../../reimbursement';
import { UserService } from '../../user.service';
import { ReimbursementService } from '../../reimbursement.service';
import { switchMap } from 'rxjs/operators';
import { ActivatedRoute } from '@angular/router';
import { ReimbursementStatus } from '../../reimbursement-status.enum';

@Component({
  selector: 'app-reimbursements',
  templateUrl: './reimbursements.component.html',
  styleUrls: ['./reimbursements.component.css'],
})
export class ReimbursementsComponent implements OnInit {
  selectedStatus: string;

  constructor(private route: ActivatedRoute) {}

  ngOnInit() {
    // Subscribe to the child's routes so that we can choose the right tab based
    // on the selected status.
    this.route.firstChild.paramMap.subscribe(
      params => (this.selectedStatus = params.get('status'))
    );
  }
}
