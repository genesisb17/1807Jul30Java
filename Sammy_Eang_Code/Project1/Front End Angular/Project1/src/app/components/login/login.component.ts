import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import {Router} from '@angular/router';
import { DataService } from '../../services/data.service';
import { jwtheader } from '../../objects/jwtheader.model';
import { jwtpayload } from '../../objects/jwtpayload.model';

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

  jwthead = new jwtheader('JWT', 'sha512');
  jwtpayl = new jwtpayload(this.username, this.password, 'come and get some recipes!');

  constructor(private authService: AuthService,
              private dataService: DataService,
              private router: Router) { }

  ngOnInit() {
    console.log(this.jwthead.typ);
    console.log(this.jwthead.alg);
    console.log(this.jwtpayl.secret);
  }

  login() {
    this.authService.sendHeaderLogin(this.jwthead.typ, this.jwthead.alg).subscribe();
    this.authService.sendPayloadLogin(this.username, this.password, this.jwtpayl.secret).subscribe();
    this.authService.login().subscribe(
      data => {
        this.servletEmpId = data.emp_id;
        this.servletUsername = data.username;
        this.servletFirst = data.first_name;
        this.servletLast = data.last_name;
        this.servletEmail = data.email;
        this.servletRoleId = data.user_role_id;

        this.dataService.id = data.emp_id;
        this.dataService.role = data.user_role_id;
        this.navigate();
      }
    );
  }

  // navigate() {
  //   if (this.servletRoleId === 1) {
  //     this.router.navigateByUrl('/eview/' + this.servletEmpId);
  //   } else {
  //     this.router.navigateByUrl('/mview/' + this.servletEmpId);
  //   }
  // }

  navigate() {
    if (this.dataService.role === 1) {
      this.router.navigateByUrl('/eview/' + this.servletEmpId);
    } else {
      this.router.navigateByUrl('/mview/' + this.servletEmpId);
    }
  }
}
