import { Component, OnInit, ViewChild } from '@angular/core';
import { DatePipe, CurrencyPipe } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { Observable, merge } from 'rxjs';
import { switchMap, map } from 'rxjs/operators';

import { TableColumn } from '../../../util/table/table.component';
import { Reimbursement } from '../../../reimbursement';
import { ReimbursementService } from '../../../reimbursement.service';
import { ReimbursementStatus } from '../../../reimbursement-status.enum';
import { ReimbursementDetailsModalComponent } from '../../reimbursements/reimbursement-details-modal/reimbursement-details-modal.component';
import { MessagingService } from '../../../util/messaging.service';

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
  selector: 'app-admin-reimbursement-view',
  templateUrl: './admin-reimbursement-view.component.html',
  styleUrls: ['./admin-reimbursement-view.component.css'],
})
export class AdminReimbursementViewComponent implements OnInit {
  reimbursements$: Observable<Reimbursement[]>;
  @ViewChild(ReimbursementDetailsModalComponent)
  detailsModal: ReimbursementDetailsModalComponent;

  detailedReimbursement: Reimbursement;
  tableColumns = pendingColumns;

  constructor(
    private reimbursementService: ReimbursementService,
    private messages: MessagingService,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    // Make sure we listen both for real status changes and fake ones.
    const statuses = merge(
      this.route.paramMap.pipe(map(params => params.get('status'))),
      this.messages.getMessages('admin-status')
    );
    this.reimbursements$ = statuses.pipe(
      switchMap(statusString => {
        const status = ReimbursementStatus.parse(statusString);
        this.tableColumns =
          status === ReimbursementStatus.Pending
            ? pendingColumns
            : resolvedColumns;
        return this.reimbursementService.getAll(status);
      })
    );
  }

  openDetailsModal(r: Reimbursement): void {
    this.detailedReimbursement = r;
    this.detailsModal.open(r);
  }

  resolve(approved: boolean): void {
    this.reimbursementService
      .resolve(this.detailedReimbursement.id, approved)
      .subscribe(() => {
        // Make sure we refresh the current view.
        this.messages.send(
          'admin-status',
          this.route.snapshot.paramMap.get('status')
        );
      });
  }
}
