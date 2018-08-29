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

  private servletData: any;

  constructor(private authService: AuthService) { }

  ngOnInit() {
  }

  login() {
    if (this.username == null || this.password == null) {
      alert('please enter in something.');
    } else {
      this.authService.login(this.username, this.password).subscribe(
        user => {
          this.authService.user = user;
          console.log(user);
        });
      }
  }
}

