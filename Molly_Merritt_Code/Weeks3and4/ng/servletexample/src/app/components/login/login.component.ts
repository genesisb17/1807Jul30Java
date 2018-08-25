import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private username: string;
  private password: string;

  private servletUsername: string;
  private servletFirst: string;
  private servletLast: string;
  private servletEmail: string;

  servletData: any;

  constructor(private authService: AuthService) { }

  ngOnInit() {
  }

  login() {
    console.log(`Value of username: ${this.username}`);
    console.log(`Value of password: ${this.password}`);

    this.authService.login(this.username, this.password).subscribe(
      data => {
        console.log(data);
        this.servletData = data.firstname;
        
      }
    );
  }

}
