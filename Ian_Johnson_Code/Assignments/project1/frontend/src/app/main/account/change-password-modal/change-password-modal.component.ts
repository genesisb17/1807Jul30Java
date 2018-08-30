import {
  Component,
  OnInit,
  ViewChild,
  Output,
  EventEmitter,
} from '@angular/core';
import {
  NgbModal,
  NgbActiveModal,
  NgbModalRef,
} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-change-password-modal',
  templateUrl: './change-password-modal.component.html',
  styleUrls: ['./change-password-modal.component.css'],
})
export class ChangePasswordModalComponent implements OnInit {
  @Output()
  close = new EventEmitter<string>();
  @ViewChild('content')
  content: NgbActiveModal;
  modal: NgbModalRef;

  password = '';
  confirmPassword = '';

  passwordError = '';
  confirmPasswordError = '';

  constructor(private modalService: NgbModal) {}

  ngOnInit() {}

  handleClose(): void {
    if (!this.validate()) {
      return;
    }
    this.close.emit(this.password);
    this.modal.close();
  }

  open(): void {
    this.modal = this.modalService.open(this.content, {
      ariaLabelledBy: 'modal-title',
    });
  }

  private validate(): boolean {
    if (!this.password) {
      this.passwordError = 'Please enter a password.';
      return false;
    }
    this.passwordError = '';
    if (!this.confirmPassword) {
      this.confirmPasswordError =
        'Please confirm your password by entering it again.';
      return false;
    }
    if (this.password !== this.confirmPassword) {
      this.confirmPasswordError = 'Passwords do not match.';
      return false;
    }
    this.confirmPasswordError = '';
    return true;
  }
}
