import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { UserService } from '../../user.service';
import { User } from '../../user';
import { ChangePasswordModalComponent } from './change-password-modal/change-password-modal.component';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css'],
})
export class AccountComponent implements OnInit {
  @ViewChild(ChangePasswordModalComponent)
  changePasswordModal: ChangePasswordModalComponent;

  user: User;
  message: { text: string; classes: string[] };

  constructor(
    private userService: UserService,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    // Fetch the user every time the page is loaded.
    this.route.params.subscribe(() => this.fetchUser());
  }

  openChangePasswordModal(): void {
    this.changePasswordModal.open();
  }

  changePassword(newPassword: string): void {
    this.userService
      .updatePassword(this.user.username, newPassword)
      .subscribe(
        _ =>
          (this.message = {
            text: 'Password changed successfully.',
            classes: ['text-success'],
          })
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
}
