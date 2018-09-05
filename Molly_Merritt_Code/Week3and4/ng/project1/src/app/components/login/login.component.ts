import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Router } from '../../../../node_modules/@angular/router';
import { Employee } from '../../model/employee.model';

@Component({
  selector: 'app-component',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  static isLoggedIn: any;

  public loggedIn: boolean;

  private username: string;
  private password: string;

  private servletUsername: string;
  private servletFirst: string;
  private servletLast: string;
  private servletEmail: string;

  servletData: any;

  constructor(private router: Router, private authService: AuthService) { }

  ngOnInit() {
    this.loggedIn = false;
    console.log(this.loggedIn);
  }

  isLoggedIn(): boolean {
    return this.loggedIn;
  }

  login() {
    console.log(`Value of username: ${this.username}`);
    console.log(`Value of password: ${this.password}`);

    this.authService.login(this.username, this.password).subscribe(
      data => {
        console.log(data);
        this.servletFirst = data.firstname;
        this.servletLast = data.lastname;
        this.servletUsername = data.username;
        this.servletEmail = data.email;
        this.loggedIn = true;
        console.log(this.loggedIn);

        this.router.navigate(['/account', {
          loggedUsername: this.servletUsername,
          loggedFirstname: this.servletFirst,
          loggedLastname: this.servletLast,
          loggedEmail: this.servletEmail
        }]);

      }
    );
  }

}
