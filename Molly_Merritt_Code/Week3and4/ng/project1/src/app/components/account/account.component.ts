import { Component, OnInit } from '@angular/core';
import { LoginComponent } from 'src/app/components/login/login.component';
import { ActivatedRoute } from '@angular/router';
import { Employee } from '../../model/employee.model';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})

export class AccountComponent implements OnInit {

  emp: Employee;

  private loginComp: LoginComponent;
  private isLoggedIn: boolean;

  private loggedFirstname: string;
  private loggedLastname: string;
  private loggedUsername: string;
  private loggedEmail: string;

  constructor(private route: ActivatedRoute) { }

  ngOnInit() {  // use the service - subscribe and then parse user
    console.log('account view');
    // this.isLoggedIn = LoginComponent.isLoggedIn();
    // console.log(this.isLoggedIn);
    this.route.params.subscribe(
      params => {
        this.loggedUsername = params['loggedUsername'];
        this.loggedFirstname = params['loggedFirstname'];
        this.loggedLastname = params['loggedLastname'];
        this.loggedEmail = params['loggedEmail'];
      });
    console.log('loggedFirstname -> ' + this.loggedFirstname);
    console.log('loggedUsername -> ' + this.loggedUsername);
    // this.populateUserTable();
    // call filter
  }

  // javascript - GET RID OF THIS
  // populateUserTable() {
  //   const row = document.createElement('tr');
  //   const cell1 = document.createElement('td');
  //   const cell2 = document.createElement('td');
  //   const cell3 = document.createElement('td');
  //   const cell4 = document.createElement('td');

  //   cell1.innerHTML = this.loggedUsername;
  //   cell2.innerHTML = this.loggedFirstname;
  //   cell3.innerHTML = this.loggedLastname;
  //   cell4.innerHTML = this.loggedEmail;

  //   row.appendChild(cell1);
  //   row.appendChild(cell2);
  //   row.appendChild(cell3);
  //   row.appendChild(cell4);

  //   document.getElementById('userTable').appendChild(row);
  // }

  // getUser() {

  // }

}
