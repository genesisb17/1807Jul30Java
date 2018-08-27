import { Component, OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable, throwError } from 'rxjs';
import { switchMap, tap } from 'rxjs/operators';

import { Reimbursement } from '../../../reimbursement';
import { ReimbursementService } from '../../../reimbursement.service';
import { UserService } from '../../../user.service';
import { ReimbursementStatus } from '../../../reimbursement-status.enum';
import { TableColumn } from '../../../util/table/table.component';

/**
 * The columns to use for the pending table.
 */
const pendingColumns: TableColumn[] = [
  {
    title: 'Type',
    property: 'type',
    formatter: (t: string) =>
      t.charAt(0).toUpperCase() + t.substring(1).toLowerCase(),
  },
  { title: 'Amount', property: 'amount' },
  {
    title: 'Submitted',
    property: 'submitted',
    formatter: (d: Date) => new DatePipe('en-US').transform(d, 'medium'),
  },
];

/**
 * The columns to use for the approved and denied tables.
 */
const resolvedColumns = pendingColumns.concat([
  {
    title: 'Resolved',
    property: 'resolved',
    formatter: (d: Date) => new DatePipe('en-US').transform(d, 'medium'),
  },
]);

@Component({
  selector: 'app-reimbursement-view',
  templateUrl: './reimbursement-view.component.html',
  styleUrls: ['./reimbursement-view.component.css'],
})
export class ReimbursementViewComponent implements OnInit {
  reimbursements$: Observable<Reimbursement[]>;
  selectedStatus: ReimbursementStatus;

  tableColumns = pendingColumns;

  constructor(
    private reimbursementService: ReimbursementService,
    private userService: UserService,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.reimbursements$ = this.route.paramMap.pipe(
      switchMap(params => {
        const status = ReimbursementStatus.parse(params.get('status'));
        this.selectedStatus = status;
        this.tableColumns =
          status === ReimbursementStatus.Pending
            ? pendingColumns
            : resolvedColumns;
        return this.userService.getCurrentUser();
      }),
      switchMap(user =>
        this.reimbursementService.getByAuthor(user.id, this.selectedStatus)
      )
    );
  }
}
