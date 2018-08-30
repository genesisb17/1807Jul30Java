import { Component, OnInit, ViewChild } from '@angular/core';
import {
  NgbModalRef,
  NgbActiveModal,
  NgbModal,
} from '@ng-bootstrap/ng-bootstrap';
import { User } from '../../../user';
import { UserRole } from '../../../user-role.enum';

@Component({
  selector: 'app-user-details-modal',
  templateUrl: './user-details-modal.component.html',
  styleUrls: ['./user-details-modal.component.css'],
})
export class UserDetailsModalComponent implements OnInit {
  user: User;

  @ViewChild('content')
  content: NgbActiveModal;
  modal: NgbModalRef;

  constructor(private modalService: NgbModal) {}

  ngOnInit() {}

  open(u: User): void {
    this.user = u;
    this.modal = this.modalService.open(this.content, {
      ariaLabelledBy: 'modal-title',
    });
  }

  formatUserRole(): string {
    return UserRole.format(this.user.role);
  }
}
