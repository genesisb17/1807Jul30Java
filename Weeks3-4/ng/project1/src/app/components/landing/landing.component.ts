import { Employee } from '../../models/employee.model';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Reimbursement } from '../../models/reimbursement.model';
import { HttpeeService } from '../../services/httpee.service';

@Component({
  selector: 'app-landing',
  templateUrl: './landing.component.html',
  styleUrls: ['./landing.component.css']
})
export class LandingComponent implements OnInit {

  reimbursements: Reimbursement[] = [];

  newReimbursement: Reimbursement = new Reimbursement();

  employee: Employee;


  constructor( private router: Router, private httpService: HttpeeService) { 
    console.log('In reimbursement component constructor');
  }



  ngOnInit() {
    this.getAllReimbursements();
    console.log('IN Landing COMPONENT NG ON INIT');
  }

  getAllReimbursements(){
    this.httpService.getReimbursements().subscribe(
      t => {
        if(t != null){
          this.reimbursements = t;
          // console.log('loaded reimbursements');
          console.log(this.reimbursements);
        } else {    // console.error('Error loading Reimbursements');
        }
        // console.log(t);        
      }      
    )    
  }

}
