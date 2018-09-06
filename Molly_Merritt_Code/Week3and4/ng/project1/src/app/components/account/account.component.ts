import { Component, OnInit } from '@angular/core';
import { LoginComponent } from 'src/app/components/login/login.component';
import { ActivatedRoute } from '@angular/router';
import { User } from '../../model/user.model';
import { AuthService } from '../../services/auth.service';
import { Router } from '../../../../node_modules/@angular/router';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})

export class AccountComponent implements OnInit {

  // userId: number;

  constructor(private route: ActivatedRoute, private router: Router, private http: AuthService) { }

  ngOnInit() {  // use the service - subscribe and then parse user
    console.log('account view');
    this.route.params.subscribe(
      params => {
        this.http.user.id = params['loggedUserId'];
        this.http.user.username = params['loggedUsername'];
        this.http.user.firstname = params['loggedFirstname'];
        this.http.user.lastname = params['loggedLastname'];
        this.http.user.email = params['loggedEmail'];
        this.http.user.roleId = params['loggedUserRoleId'];
      });
    // console.log('loggedUserId -> ' + this.http.user.id);
    // console.log('loggedFirstname -> ' + this.http.user.firstname);
    // console.log('loggedUsername -> ' + this.http.user.username);
    // console.log('loggedEmail -> ' + this.http.user.email);
    // console.log('loggedUserRoleId -> ' + this.http.user.roleId);
    // call filter
  }

  reimbNavigate() {
    this.router.navigate(['/reimbursements', {
      loggedUserId: this.http.user.id,
      loggedUsername: this.http.user.username,
      loggedFirstname: this.http.user.firstname,
      loggedLastname: this.http.user.lastname,
      loggedEmail: this.http.user.email,
      loggedUserRoleId: this.http.user.roleId
    }]);
  }

  logout() {
    this.router.navigate(['/login']);
  }

}
