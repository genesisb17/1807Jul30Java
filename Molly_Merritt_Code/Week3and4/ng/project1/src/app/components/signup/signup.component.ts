import { Component, OnInit } from '@angular/core';

import { AuthService } from 'src/app/services/auth.service';
import { Router } from '../../../../node_modules/@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  private username: string;
  private password: string;
  private firstname: string;
  private lastname: string;
  private email: string;
  private roleId: number;

  constructor(private router: Router, private http: AuthService) { }

  ngOnInit() {
  }

  signup() {
    // http signup method
    this.http.signup(this.username, this.password, this.firstname, this.lastname,
      this.email, this.roleId).subscribe(
      data => {
        this.http.user = data;
        console.log(this.http.user);

        this.router.navigate(['/login']);
      }
    );
  }

  updateRoleId() {
    console.log(event.target.value);
    this.roleId = parseInt(event.target.value);
  }

  loginNavigate() {
    this.router.navigate(['/login']);
  }

}
