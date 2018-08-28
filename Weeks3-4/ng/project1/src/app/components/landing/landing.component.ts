import { Component, OnInit } from '@angular/core';
import { Employee } from '../../models/employee.model';
import { LoginService } from '../../services/login.service';
@Component({
  selector: 'app-landing',
  templateUrl: './landing.component.html',
  styleUrls: ['./landing.component.css']
})
export class LandingComponent implements OnInit {

  employee: Employee;

  constructor(private loginService: LoginService) { }

  ngOnInit() {
    this.employee = this.loginService.currentEmployee;
  }

}
