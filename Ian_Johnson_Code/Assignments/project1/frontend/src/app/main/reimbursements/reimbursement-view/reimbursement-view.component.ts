import { Component, OnInit, ViewChild } from '@angular/core';
import { DatePipe, CurrencyPipe } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { Observable, merge } from 'rxjs';
import { switchMap, map } from 'rxjs/operators';

import { Reimbursement } from '../../../reimbursement';
import { ReimbursementService } from '../../../reimbursement.service';
import { UserService } from '../../../user.service';
import { ReimbursementStatus } from '../../../reimbursement-status.enum';
import { TableColumn } from '../../../util/table/table.component';
import { MessagingService } from '../../../util/messaging.service';
import { ReimbursementDetailsModalComponent } from '../reimbursement-details-modal/reimbursement-details-modal.component';

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
  {
    title: 'Amount',
    property: 'amount',
    formatter: (t: string) => new CurrencyPipe('en-US').transform(t, 'USD'),
  },
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
  @ViewChild(ReimbursementDetailsModalComponent)
  detailsModal: ReimbursementDetailsModalComponent;

  tableColumns = pendingColumns;

  constructor(
    private reimbursementService: ReimbursementService,
    private userService: UserService,
    private messages: MessagingService,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    // Make sure we listen both for real status changes and fake ones.
    const statuses = merge(
      this.route.paramMap.pipe(map(params => params.get('status'))),
      this.messages.getMessages('status')
    );

    let status: ReimbursementStatus;
    this.reimbursements$ = statuses.pipe(
      switchMap(statusString => {
        status = ReimbursementStatus.parse(statusString);
        this.tableColumns =
          status === ReimbursementStatus.Pending
            ? pendingColumns
            : resolvedColumns;
        return this.userService.getCurrentUser();
      }),
      switchMap(user => this.reimbursementService.getByAuthor(user.id, status))
    );
  }

  openDetailsModal(r: Reimbursement): void {
    this.detailsModal.open(r);
  }
}
