import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../service/auth.service';

@Component({
  selector: 'app-createuser',
  templateUrl: './createuser.component.html',
  styleUrls: ['./createuser.component.css']
})
export class CreateuserComponent implements OnInit {

  constructor(private authService: AuthService) { }

  private username: string;
  private password: string;
  private firstname: string;
  private lastname: string;
  private email: string;
  private typeVal: number;
  private message: string;

  ngOnInit() 
  {
  }

  createAccount()
  {
    this.message = "";
    this.authService.createAccount(this.username, this.password, this.firstname, this.lastname, this.email, this.typeVal).subscribe(
      data => {
        this.authService.temp = data;

        if(this.authService.temp.ers_username == null)
        {
          this.message = "(Username is not unique)";
        }
        else if(this.authService.temp.user_email == null)
        {
          this.message = "(Email is not unique)";
        }
      });
    //.subscribe(data => {this.authService.servletData = data;})
    this.username = null;
    this.password = null;
    this.firstname = null;
    this.lastname = null;
    this.email = null;
  }
}
