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

  servletData: any;

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit() {
  }

  login() {
    console.log(`Value of username: ${this.username}`);
    console.log(`Value of password: ${this.password}`);

    this.authService.login(this.username, this.password).subscribe(
      data => {
        if (data) {
          this.authService.setUserData(data.userId, data.roleId, data.firstname + " " + data.lastname);
          this.router.navigateByUrl('/reimbView');
        } else {
          this.router.navigateByUrl('/login');
        }
      }
    );
  }
}
