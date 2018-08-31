import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpeeService } from '../../services/httpee.service';

@Component({
  selector: 'app-transition',
  templateUrl: './transition.component.html',
  styleUrls: ['./transition.component.css']
})
export class TransitionComponent implements OnInit {

  constructor(private router: Router, private httpee: HttpeeService) { }

  ngOnInit() {
  }

  backToAllReimbursements(){
    this.router.navigate(['reimbursement']);
  }

  backToEmployeeReimbursements(){
    this.router.navigate(['landing']);
  }

}
