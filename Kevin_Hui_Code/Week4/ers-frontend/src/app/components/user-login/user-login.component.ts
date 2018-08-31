import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {

  private username: string;
  private password: string;

  private servletUserID: number;
  private servletUsername: string;
  private servletFirst: string;
  private servletLast: string;
  private servletEmail: string;
  private servletRoleID: number;

  servletData: any;

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit() {
  }

  login() {
    console.log(`Value of username: ${this.username}`);
    console.log(`Value of password: ${this.password}`);

    this.authService.login(this.username, this.password).subscribe(
      data => {
        console.log(data);
        if (data) {
          this.servletFirst = data.firstname;
          this.servletLast = data.lastname;
          this.servletUsername = data.username;
          this.servletEmail = data.email;
          this.servletUserID = data.userId;
          this.servletRoleID = data.roleId;

          if (this.servletRoleID > 0) {
            this.router.navigate(['/reimbView', this.servletUsername]);
          }
          // else if (this.servletroleID == 2 || this.servletroleID == 1) {
          //   this.router.navigate(['/table', this.servletEmpID]);
          // }
        } else {
          console.log("Nothing");
          this.router.navigateByUrl('/login');
        }
      }
    );
  }
}
