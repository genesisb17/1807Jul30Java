import { Component, OnInit, ElementRef, ViewChild } from '@angular/core';
import { tap } from 'rxjs/operators';
import { UserService } from '../../user.service';
import { User } from '../../user';
import { ActivatedRoute } from '@angular/router';
import { NgbModal, NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css'],
})
export class AccountComponent implements OnInit {
  user: User;
  message: { text: string; classes: string[] };
  @ViewChild('content')
  content: NgbActiveModal;

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
    this.modalService.open(this.content, {
      ariaLabelledBy: 'password-modal-title',
    });
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
          text: 'User info updated successfully.',
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
