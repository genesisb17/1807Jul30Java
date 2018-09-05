import { Component, OnInit } from '@angular/core';
import { LoginComponent } from 'src/app/components/login/login.component';
import { ActivatedRoute } from '@angular/router';
import { User } from '../../model/user.model';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})

export class AccountComponent implements OnInit {

  user: User;

  // private loginComp: LoginComponent;
  // private isLoggedIn: boolean;

  // private loggedFirstname: string;
  // private loggedLastname: string;
  // private loggedUsername: string;
  // private loggedEmail: string;

  constructor(private route: ActivatedRoute, private http: AuthService) { }

  ngOnInit() {  // use the service - subscribe and then parse user
    console.log('account view');
    // this.isLoggedIn = LoginComponent.isLoggedIn();
    // console.log(this.isLoggedIn);
    this.route.params.subscribe(
      params => {
        // this.loggedUsername = params['loggedUsername'];
        // this.loggedFirstname = params['loggedFirstname'];
        // this.loggedLastname = params['loggedLastname'];
        // this.loggedEmail = params['loggedEmail'];
        this.http.user.username = params['loggedUsername'];
        this.http.user.firstname = params['loggedFirstname'];
        this.http.user.lastname = params['loggedLastname'];
        this.http.user.email = params['loggedEmail'];
      });
    // console.log('loggedFirstname -> ' + this.loggedFirstname);
    // console.log('loggedUsername -> ' + this.loggedUsername);
    console.log('loggedFirstname -> ' + this.http.user.firstname);
    console.log('loggedUsername -> ' + this.http.user.username);
    // call filter
  }

}