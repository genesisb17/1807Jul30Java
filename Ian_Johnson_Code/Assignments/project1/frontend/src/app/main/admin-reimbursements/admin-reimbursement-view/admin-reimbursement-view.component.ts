import { Component, OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';
import { Observable } from 'rxjs';

import { TableColumn } from '../../../util/table/table.component';
import { Reimbursement } from '../../../reimbursement';
import { ReimbursementService } from '../../../reimbursement.service';
import { ActivatedRoute } from '@angular/router';
import { ReimbursementStatus } from '../../../reimbursement-status.enum';
import { switchMap } from 'rxjs/operators';

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
  selector: 'app-admin-reimbursement-view',
  templateUrl: './admin-reimbursement-view.component.html',
  styleUrls: ['./admin-reimbursement-view.component.css'],
})
export class AdminReimbursementViewComponent implements OnInit {
  reimbursements$: Observable<Reimbursement[]>;

  tableColumns = pendingColumns;

  constructor(
    private reimbursementService: ReimbursementService,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.reimbursements$ = this.route.paramMap.pipe(
      switchMap(params => {
        const status = ReimbursementStatus.parse(params.get('status'));
        this.tableColumns =
          status === ReimbursementStatus.Pending
            ? pendingColumns
            : resolvedColumns;
        return this.reimbursementService.getAll(status);
      })
    );
  }
}
