import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth/auth.service';
import { Router } from '@angular/router';
import { User } from '../../model/user.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private username: string;
  private password: string;
  user: User;

  constructor(private authService: AuthService, private route: Router) { }

  ngOnInit() {
    this.authService.getCurrentUser().subscribe(data => { this.authService.user = data;
    if (this.authService.user !== null) {
      this.route.navigate(['successful']);
    } });
  }

  login() {
    if (this.username == null || this.password == null) {
      alert('Input boxes cannot be empty.');
    } else {
        this.authService.login(this.username, this.password)
          .subscribe(user => { this.authService.user = user;
        // Routes user based on what they put in
        if (this.authService.user.username === 'test1') {
          this.route.navigate(['successful']);
        } else if (this.authService.user.username === 'admin' ) {
          this.route.navigate(['admin']);
        }
      }
    , error => { alert('Incorrect login credentials.');
  });
    }
  }
}
