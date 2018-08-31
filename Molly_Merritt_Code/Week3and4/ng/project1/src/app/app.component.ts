import { Component, OnInit } from '@angular/core';
import { LoginComponent } from 'src/app/components/login/login.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  private loginComp: LoginComponent;
  // private isLoggedIn: boolean;

  ngOnInit() {
    // this.loginComp.loggedIn = false;
    // console.log(this.loginComp.loggedIn);
  }

}
