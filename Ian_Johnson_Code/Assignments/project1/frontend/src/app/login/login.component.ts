import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { UserRole } from '../user-role.enum';
import { Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  username: string;
  password: string;

  usernameError = '';
  passwordError = '';
  error = '';

  constructor(
    private loginService: LoginService,
    private userService: UserService,
    private router: Router
  ) {}

  ngOnInit() {
    // Check to see if the user is already logged in.
    this.userService.getCurrentUser().subscribe(_ => {
      this.router.navigate(['home']);
    });
  }

  login(): void {
    if (!this.username) {
      this.usernameError = 'Please enter your username.';
      return;
    }
    this.usernameError = '';
    if (!this.password) {
      this.passwordError = 'Please enter your password.';
      return;
    }
    this.passwordError = '';
    this.loginService
      .login(this.username, this.password)
      .subscribe(
        _ => this.router.navigate(['home']),
        error => (this.error = error)
      );
  }
}
