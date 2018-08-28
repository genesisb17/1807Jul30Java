import { Component, OnInit, ElementRef, ViewChild } from '@angular/core';
import { tap } from 'rxjs/operators';
import { UserService } from '../../user.service';
import { User } from '../../user';
import { ActivatedRoute } from '@angular/router';
import {
  NgbModal,
  NgbActiveModal,
  NgbModalRef,
} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css'],
})
export class AccountComponent implements OnInit {
  user: User;
  message: { text: string; classes: string[] };
  passwordMessage: { text: string; classes: string[] };
  @ViewChild('content')
  content: NgbActiveModal;
  passwordModal: NgbModalRef;

  // For the password change modal.
  newPassword: string;
  confirmPassword: string;

  constructor(
    private userService: UserService,
    private route: ActivatedRoute,
    private modalService: NgbModal
  ) {}

  ngOnInit() {
    // Fetch the user every time the page is loaded.
    this.route.params.subscribe(() => this.fetchUser());
  }

  changePassword(): void {
    this.passwordModal = this.modalService.open(this.content, {
      ariaLabelledBy: 'password-modal-title',
    });
  }

  closeChangePassword(): void {
    if (!this.validateChangePassword()) {
      return;
    }
    this.userService
      .updatePassword(this.user.username, this.newPassword)
      .subscribe(
        () => {
          this.passwordModal.close();
        },
        err => {
          this.passwordMessage = {
            text: err,
            classes: ['text-danger'],
          };
        }
      );
  }

  fetchUser(): void {
    this.userService.getCurrentUser().subscribe(user => (this.user = user));
  }

  formatRole(): string {
    return (
      this.user.role.charAt(0).toUpperCase() +
      this.user.role.substring(1).toLowerCase()
    );
  }

  updateInfo(): void {
    if (!this.validate()) {
      return;
    }
    this.userService.update(this.user).subscribe(
      user => {
        this.message = {
          text: 'User information updated successfully.',
          classes: ['text-success'],
        };
        this.user = user;
      },
      err => {
        this.message = {
          text: err,
          classes: ['text-danger'],
        };
      }
    );
  }

  /**
   * Validates the input fields, displaying a message if there are any errors.
   *
   * @returns if all input is valid
   */
  private validate(): boolean {
    if (!this.user.firstName || !this.user.lastName || !this.user.email) {
      this.message = {
        text: 'Please fill in all required fields.',
        classes: ['text-danger'],
      };
      return false;
    }
    return true;
  }

  private validateChangePassword(): boolean {
    if (!this.newPassword || !this.confirmPassword) {
      this.passwordMessage = {
        text: 'Please fill in all fields.',
        classes: ['text-danger'],
      };
      return false;
    }
    if (this.newPassword !== this.confirmPassword) {
      this.passwordMessage = {
        text: 'Given passwords do not match.',
        classes: ['text-danger'],
      };
      return false;
    }
    return true;
  }
}
