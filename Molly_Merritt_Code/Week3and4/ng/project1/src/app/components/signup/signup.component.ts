import { Component, OnInit } from '@angular/core';

import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  private username: string;
  private password: string;
  private firstname: string;
  private lastname: string;
  private email: string;

  constructor(private http: AuthService) { }

  ngOnInit() {
  }

  signup() {
    // http signup method
  }

}
