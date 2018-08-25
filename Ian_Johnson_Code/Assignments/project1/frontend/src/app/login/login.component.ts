import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { UserRole } from '../user-role.enum';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  username: string;
  password: string;
  error: string;

  constructor(private loginService: LoginService) {}

  ngOnInit() {}

  login() {
    this.loginService
      .login(this.username, this.password)
      .subscribe(
        user => console.log(`Got user: ${JSON.stringify(user)}`),
        error => (this.error = error)
      );
  }
}
