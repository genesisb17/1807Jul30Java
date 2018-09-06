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

  // user: User;

  constructor(private route: ActivatedRoute, private router: Router, private http: AuthService) { }

  ngOnInit() {  // use the service - subscribe and then parse user
    console.log('account view');
    this.route.params.subscribe(
      params => {
        this.http.user.username = params['loggedUsername'];
        this.http.user.firstname = params['loggedFirstname'];
        this.http.user.lastname = params['loggedLastname'];
        this.http.user.email = params['loggedEmail'];
      });
    console.log('loggedFirstname -> ' + this.http.user.firstname);
    console.log('loggedUsername -> ' + this.http.user.username);
    // call filter
  }

  reimbNavigate() {
    this.router.navigate(['/reimbursements', {
      loggeduserId: this.http.user.id,
      loggedUsername: this.http.user.username,
      loggedFirstname: this.http.user.firstname,
      loggedLastname: this.http.user.lastname,
      loggedEmail: this.http.user.email
    }]);
  }

}
