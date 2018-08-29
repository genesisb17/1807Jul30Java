import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../service/auth.service';
import { Time } from '@angular/common';
import { RouterModule, Router } from '@angular/router';
import { User } from '../../model/user';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: User;
  private username: string;
  private password: string;
  private err: string;
  


  servletData: any;
  constructor(private authService: AuthService,
    private route: RouterModule,
    private router: Router
  ) { }



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
          if (user != null) {
            this.authService.isLoggedIn = true;
            this.router.navigate(['userinfo']);
          }
        }
      );
    }
  }

}


