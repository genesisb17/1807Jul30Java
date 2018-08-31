import { Component, OnInit } from '@angular/core';
import { LoginComponent } from 'src/app/components/login/login.component';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})

export class AccountComponent implements OnInit {

  private loginComp: LoginComponent;
  private isLoggedIn: boolean;

  constructor() { }

  ngOnInit() {
    console.log('account view');
    this.isLoggedIn = LoginComponent.loggedIn;
    console.log(this.isLoggedIn);
  }

  getUser() {

  }

}
