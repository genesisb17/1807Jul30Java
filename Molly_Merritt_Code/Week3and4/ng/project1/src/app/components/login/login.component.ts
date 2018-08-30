import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-component',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public loggedIn: boolean;

  private username: string;
  private password: string;

  private servletUsername: string;
  private servletFirst: string;
  private servletLast: string;
  private servletEmail: string;

  servletData: any;

  constructor(private authService: AuthService) { }

  ngOnInit() {
    this.loggedIn = false;
  }

  login() {
    console.log(`Value of username: ${this.username}`);
    console.log(`Value of password: ${this.password}`);

    // askForSomething();
    // this.authService.askForSomething().subscribe(
    //   function(myParam) {
    //     console.log('---> ' + myParam);
    //   }
    // );

    this.authService.login(this.username, this.password).subscribe(
      data => {
        console.log(data);
        this.servletFirst = data.firstname;
        this.servletLast = data.lastname;
        this.servletUsername = data.username;
        this.servletEmail = data.email;
        this.loggedIn = true;
      }
    );
  }

}
