import {
  Component,
  OnInit,
  ViewChild,
  Output,
  EventEmitter,
} from '@angular/core';
import {
  NgbActiveModal,
  NgbModalRef,
  NgbModal,
} from '@ng-bootstrap/ng-bootstrap';

import { User } from '../../../user';
import { UserRole } from '../../../user-role.enum';
import { UserService } from '../../../user.service';
import { Observable, of, throwError } from 'rxjs';
import { switchMap, catchError } from 'rxjs/operators';

@Component({
  selector: 'app-add-user-modal',
  templateUrl: './add-user-modal.component.html',
  styleUrls: ['./add-user-modal.component.css'],
})
export class AddUserModalComponent implements OnInit {
  @Output()
  close = new EventEmitter<{ user: User; password: string }>();
  @ViewChild('content')
  content: NgbActiveModal;
  modal: NgbModalRef;

  username = '';
  role = 'employee';
  firstName = '';
  lastName = '';
  email = '';
  generatedPassword: string;

  usernameError = '';
  roleError = '';
  firstNameError = '';
  lastNameError = '';
  emailError = '';

  constructor(
    private userService: UserService,
    private modalService: NgbModal
  ) {}

  ngOnInit() {}

  closeModal(): void {
    this.validate().subscribe(_ => {
      this.modal.close();
      const user: User = {
        id: 0,
        username: this.username,
        role: UserRole.parse(this.role),
        firstName: this.firstName,
        lastName: this.lastName,
        email: this.email,
      };
      this.close.emit({ user, password: this.generatedPassword });
    });
  }

  /**
   * Generates a random password.
   */
  generateRandomPassword(): string {
    const bytes = new Uint8Array(12);
    // Get some random bytes.
    crypto.getRandomValues(bytes);
    // Base64-encode the bytes.
    return btoa(String.fromCharCode(...Array.from(bytes)));
  }

  open(): void {
    this.generatedPassword = this.generateRandomPassword();
    this.modal = this.modalService.open(this.content, {
      ariaLabelledBy: 'modal-title',
    });
  }

  private validate(): Observable<string> {
    // Validate username.
    if (!this.username) {
      this.usernameError = 'Must provide a username.';
      return throwError(this.usernameError);
    }
    if (this.username.length > 50) {
      this.usernameError = 'Please limit usernames to 50 characters or fewer.';
      return throwError(this.usernameError);
    }
    this.usernameError = '';
    // Validate role.
    const role = UserRole.parse(this.role);
    if (!role) {
      this.roleError = 'Please select a valid user role.';
      return throwError(this.roleError);
    }
    this.roleError = '';
    // Validate first name.
    if (!this.firstName) {
      this.firstNameError = "Please enter the user's first name.";
      return throwError(this.firstNameError);
    }
    if (this.firstName.length > 100) {
      this.firstNameError =
        'Unfortunately, first names are limited to 100 characters or fewer.';
      return throwError(this.firstNameError);
    }
    this.firstNameError = '';
    // Validate last name.
    if (!this.lastName) {
      this.lastNameError = "Please enter the user's last name.";
      return throwError(this.lastNameError);
    }
    if (this.lastName.length > 100) {
      this.lastNameError =
        'Unfortunately, last names are limited to 100 characters or fewer.';
      return throwError(this.lastNameError);
    }
    this.lastNameError = '';
    // Validate email.
    if (!this.email || !this.email.match('@')) {
      this.emailError = 'Please enter a valid email address.';
      return throwError(this.emailError);
    }
    this.emailError = '';

    // Check username availability. This is a rather awkward way to swap error
    // and success conditions; I wish there were a better way to do this.
    return this.userService.getByUsername(this.username).pipe(
      catchError(_ => of('Valid input.')),
      switchMap(data => {
        if (data instanceof User) {
          this.usernameError = 'Username is already taken.';
          return throwError(this.usernameError);
        } else {
          return of(data);
        }
      })
    );
  }
}
