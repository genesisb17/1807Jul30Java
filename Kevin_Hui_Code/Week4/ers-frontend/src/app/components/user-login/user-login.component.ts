import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {

  username: string;
  password: string;

  servletData: any;

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit() {
  }

  login() {
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
