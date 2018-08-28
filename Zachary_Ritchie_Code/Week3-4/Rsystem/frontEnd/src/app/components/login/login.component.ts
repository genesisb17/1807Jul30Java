import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../service/auth.service';
import { User } from '../../user';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit 
{
  constructor(private authService: AuthService, private router: Router) { }

  private userData: User;
  private username: string;
  private password: string;  
  private message: string;

  ngOnInit() 
  {

  }

  loginFunction()
  {
    //console.log(`value of username: ${this.username}`);
    //console.log(`value of username: ${this.password}`);

    this.authService.login(this.username, this.password).subscribe(
      data => {
        this.authService.servletData = data; 
        this.userData = this.authService.servletData;
        
        if(this.userData != null)
        {
          this.router.navigate(["/home"]);
        }
        else
        {
          this.message = "(Incorrect username or password)";
        }
      });    
  }
}
