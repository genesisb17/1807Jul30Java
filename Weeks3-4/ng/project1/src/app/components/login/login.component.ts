import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../../services/login.service';

@Component({ //shows up in app.component.html as tag
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private username: string;
  private password: string;

  servletData: any;

  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit() {
    this.loginService.subscribeToLogin(()=>{
      this.router.navigate([" "])
    });
  }


  // login() {
  //   console.log(`Value of username: ${this.username}`);
  //   console.log(`Value of password: ${this.password}`);

  //   this.loginService.login(this.username, this.password).subscribe(
  //     data => {
  //       console.log(data);
  //     }
  //   );
  // }
  login(){
    console.log("in login method" + this.username);
      this.loginService.validate(this.username, this.password);
    }
  
    register(){//-  -   -   - - - - - - - - - - - - - - was "register"
      this.router.navigate(["new-employee"])
    }

}
