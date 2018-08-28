import {
  Component,
  OnInit,
  EventEmitter,
  Output,
  ViewChild,
  Input,
} from '@angular/core';
import {
  NgbModalRef,
  NgbActiveModal,
  NgbModal,
} from '@ng-bootstrap/ng-bootstrap';
import { Reimbursement } from '../../../reimbursement';

@Component({
  selector: 'app-reimbursement-details-modal',
  templateUrl: './reimbursement-details-modal.component.html',
  styleUrls: ['./reimbursement-details-modal.component.css'],
})
export class ReimbursementDetailsModalComponent implements OnInit {
  @Output()
  close = new EventEmitter<void>();
  @Input()
  reimbursement: Reimbursement;
  @ViewChild('content')
  content: NgbActiveModal;
  modal: NgbModalRef;

  constructor(private modalService: NgbModal) {}

  ngOnInit() {}

  closeModal(): void {
    this.modal.close();
    this.close.emit();
  }

  open(): void {
    this.modal = this.modalService.open(this.content, {
      ariaLabelledBy: 'modal-title',
    });
  }
}
