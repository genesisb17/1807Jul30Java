import { Component, OnInit, ViewChild } from '@angular/core';
import { Reimbursement } from '../../reimbursement';
import { ReimbursementService } from '../../reimbursement.service';
import { ActivatedRoute } from '@angular/router';
import { AddReimbursementModalComponent } from './add-reimbursement-modal/add-reimbursement-modal.component';
import { MessagingService } from '../../util/messaging.service';

@Component({
  selector: 'app-reimbursements',
  templateUrl: './reimbursements.component.html',
  styleUrls: ['./reimbursements.component.css'],
})
export class ReimbursementsComponent implements OnInit {
  @ViewChild(AddReimbursementModalComponent)
  addReimbursementModal: AddReimbursementModalComponent;

  selectedStatus: string;

  constructor(
    private reimbursementService: ReimbursementService,
    private messages: MessagingService,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    // Subscribe to the child's routes so that we can choose the right tab based
    // on the selected status.
    this.route.firstChild.paramMap.subscribe(
      params => (this.selectedStatus = params.get('status'))
    );
  }

  addReimbursement(r: Reimbursement) {
    this.reimbursementService.submit(r).subscribe(_ => {
      // Refresh the current view.
      this.messages.send('status', this.selectedStatus);
    });
  }

  openAddReimbursementModal(): void {
    this.addReimbursementModal.open();
  }
}
