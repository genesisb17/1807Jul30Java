import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Router } from '../../../../node_modules/@angular/router';
import { User } from '../../model/user.model';

@Component({
  selector: 'app-component',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  private username: string;
  private password: string;

  servletData: any;

  constructor(private router: Router, private http: AuthService) { }

  ngOnInit() {
    console.log('in ngOnInit() in login component');
  }

  login() {
    console.log(`Value of username: ${this.username}`);
    console.log(`Value of password: ${this.password}`);

    this.http.login(this.username, this.password).subscribe(
      data => {
        this.http.user = data;
        console.log(this.http.user);
        // console.log(this.http.user.id);
        console.log('user role id = ' + this.http.user.roleId);

        this.router.navigate(['/account', {
          loggedUserId: this.http.user.id,
          loggedUsername: this.http.user.username,
          loggedFirstname: this.http.user.firstname,
          loggedLastname: this.http.user.lastname,
          loggedEmail: this.http.user.email,
          loggedUserRoleId: this.http.user.roleId
        }]);
      }
    );
  }

  signupNavigate() {
    this.router.navigate(['/signup']);
  }

}
