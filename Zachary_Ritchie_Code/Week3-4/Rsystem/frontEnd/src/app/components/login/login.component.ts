import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../service/auth.service';
import { User } from '../../user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit 
{
  constructor(private authService: AuthService) { }

  public receivedData: User;
  private username: string;
  private password: string;  

  ngOnInit() 
  {

  }

  loginFunction()
  {
    //console.log(`value of username: ${this.username}`);
    //console.log(`value of username: ${this.password}`);

    this.authService.login(this.username, this.password).subscribe(data => {this.authService.servletData = data;});
    this.receivedData = this.authService.servletData; 
  }
}
