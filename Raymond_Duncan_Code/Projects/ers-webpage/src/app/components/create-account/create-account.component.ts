import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { User } from '../models/user';

@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.css']
})
export class CreateAccountComponent implements OnInit {

  private username: string;
  private password: string;
  private firstname: string;
  private lastname: string;
  private email: string;

  private data: User;

  constructor(private authService: AuthService) { }

  ngOnInit() {
  }

  createAccount() {
    this.authService.createAccount(this.username, this.password, this.firstname, this.lastname, this.email).subscribe(
      data => {
        this.data = data;
        console.log(this.data);
      }
    );
    this.username = '';
    this.password = '';
    this.firstname = '';
    this.lastname = '';
    this.email = '';
  }

}
