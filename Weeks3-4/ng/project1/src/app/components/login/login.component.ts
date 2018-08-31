import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../../services/login.service';
import { Employee } from '../../models/employee.model';
import { HttpeeService } from '../../services/httpee.service';

@Component({ //shows up in app.component.html as tag
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private username: string;
  private password: string;
  private message: string;
  private emp: Employee;

  constructor(private loginService: LoginService, private router: Router, private httpService: HttpeeService) { }

  ngOnInit() {

  }

  getCurrentEmployee(){
    return this.httpService.temp;
  }

  login(){
    console.log("in login method for " + this.username);
//      this.loginService.validate(this.username, this.password);
      this.loginService.validate(this.username, this.password).subscribe(
        temp => {
          this.emp = temp;
          console.log(temp + " in login component");
          console.log(this.emp);
         if(this.emp != null){
            this.router.navigate(["landing"]);
            console.log("logged in")
          } else {
            this.message="Incorrect Username or Password";
           }
          
        }
      )
    }
      
    register(){//-  -   -   - - - - - - - - - - - - - - was "register"
      this.router.navigate(["home"])
    }
  }
