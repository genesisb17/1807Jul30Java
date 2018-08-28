import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';

@Component({ //shows up in app.component.html as tag
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private username: string;
  private password: string;

  servletData: any;

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit() {
    this.authService.subscribeToLogin(()=>{
      this.router.navigate([" "])
    });
  }


  login() {
    console.log(`Value of username: ${this.username}`);
    console.log(`Value of password: ${this.password}`);

    this.authService.login(this.username, this.password).subscribe(
      data => {
        console.log(data);
      }
    );
  }
}
