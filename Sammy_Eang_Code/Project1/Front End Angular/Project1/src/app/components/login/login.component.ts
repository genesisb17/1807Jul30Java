import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string;
  password: string;

  servletEmpId: number;
  servletUsername: string;
  servletPassword: string;
  servletFirst: string;
  servletLast: string;
  servletEmail: string;
  servletRoleId: number;

  servletData: any;

  constructor(private authService: AuthService,
              private router: Router) { }

  ngOnInit() {
  }

  login() {
    this.authService.login(this.username, this.password).subscribe(
      data => {
        this.servletEmpId = data.emp_id;
        this.servletUsername = data.username;
        this.servletFirst = data.first_name;
        this.servletLast = data.last_name;
        this.servletEmail = data.email;
        this.servletRoleId = data.user_role_id;
        this.navigate();
      }
    );
  }

  navigate() {
    // if (this.servletRoleId === 1) {
    //
    // }
    this.router.navigateByUrl('/eview/' + this.servletEmpId);
  }

}
