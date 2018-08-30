import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { User } from '../models/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private username: string;
  private password: string;

  private invalidCredentials = false;
  private data: User;

  constructor(
    private authService: AuthService,
    private router: Router) { }

  ngOnInit() {
  }

  login(username: string, password: string) {
    console.log(`From LoginComponent -  username: ${this.username}, password: ${this.password}`);
    this.authService.login(this.username, this.password).subscribe(
      data => {
        this.data = data;
        console.log( this.data);
        if (this.data === null) {
          // No user returned...
          console.log('No user received');
          this.invalidCredentials = true;
        } else {
          // User returned...
          console.log('User received!');
          this.invalidCredentials = false;
          this.router.navigateByUrl('/landing');
        }
      });
    this.username = '';
    this.password = '';
  }

}
