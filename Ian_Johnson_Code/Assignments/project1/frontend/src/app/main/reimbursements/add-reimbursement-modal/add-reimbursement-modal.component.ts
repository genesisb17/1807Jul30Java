import {
  Component,
  OnInit,
  EventEmitter,
  Output,
  ViewChild,
} from '@angular/core';
import {
  NgbModal,
  NgbActiveModal,
  NgbModalRef,
} from '@ng-bootstrap/ng-bootstrap';
import { Decimal } from 'decimal.js';
import { Reimbursement } from '../../../reimbursement';
import { ReimbursementType } from '../../../reimbursement-type.enum';
import { ReimbursementStatus } from '../../../reimbursement-status.enum';

@Component({
  selector: 'app-add-reimbursement-modal',
  templateUrl: './add-reimbursement-modal.component.html',
  styleUrls: ['./add-reimbursement-modal.component.css'],
})
export class AddReimbursementModalComponent implements OnInit {
  @Output()
  close = new EventEmitter<Reimbursement>();
  @ViewChild('content')
  content: NgbActiveModal;
  modal: NgbModalRef;

  type = 'lodging';
  amount = '0.00';
  description = '';

  typeError = '';
  amountError = '';
  descriptionError = '';

  constructor(private modalService: NgbModal) {}

  ngOnInit() {}

  closeModal(): void {
    if (!this.validate()) {
      return;
    }
    const type = ReimbursementType.parse(this.type);
    const reimbursement: Reimbursement = {
      type,
      amount: new Decimal(this.amount),
      description: this.description,
      // These four properties are ignored on submission:
      id: 0,
      status: ReimbursementStatus.Pending,
      authorId: 0,
      submitted: null,
    };
    // Reset to default values.
    this.type = 'lodging';
    this.amount = '0.00';
    this.description = '';

    this.modal.close();
    this.close.emit(reimbursement);
  }

  open(): void {
    this.modal = this.modalService.open(this.content, {
      ariaLabelledBy: 'modal-title',
    });
  }

  private validate(): boolean {
    if (!this.type || !ReimbursementType.parse(this.type)) {
      this.typeError = 'Please provide a valid reimbursement type.';
      return false;
    }
    this.typeError = '';
    if (!this.amount) {
      this.amountError = 'Please provide an amount.';
      return false;
    }
    if (
      !/^[0-9]+(\.[0-9]{1,2})?$/.test(this.amount) ||
      parseFloat(this.amount) <= 0
    ) {
      this.amountError =
        'Please specify a positive amount with no fractional cents.';
      return false;
    }
    this.amountError = '';
    if (this.description.length > 500) {
      this.descriptionError =
        'Please limit descriptions to 500 characters or fewer.';
      return false;
    }
    this.descriptionError = '';
    return true;
  }
}
