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
  empReimbursements: Reimbursement[] = [];
  newReimbursement: Reimbursement = new Reimbursement();

  employee: Employee;


  constructor( private router: Router, private httpService: HttpeeService) { 
    console.log('In reimbursement component constructor');
  }

  ngOnInit() {
    this.getAllReimbursements();
    // this.getCurrentEmployeeReimbursements();
    if(this.httpService.temp != null){
      this.getCurrentEmployeeReimbursements();
    }
    console.log('IN Landing COMPONENT NG ON INIT');
  }

  getCurrentEmployeeReimbursements(){
    console.log("getting current employee reimbursements");
    console.log(this.httpService.temp.employee_id + " current employee id");
    let emp = this.httpService.temp;
    this.httpService.getReimbursements().subscribe(	// este es el servicio 
      reimb => {																	
        if (reimb !== null) {

          this.empReimbursements = reimb.filter(function(element, index, array) {
                     
            if (  ( element.author == emp.employee_id ) ) {
              console.log("in loop")
                    return true;
            } else {
              return false;
            }

          });
          
        } else {
          console.log('Reimbursements were not loaded.'
        );
        }
      }
    )
  }


  getAllReimbursements(){
    this.httpService.getReimbursements().subscribe(
      t => {
        if(t != null){
          this.reimbursements = t;
          console.log('loaded reimbursements');
          console.log(this.reimbursements);
        } else {    // console.error('Error loading Reimbursements');
        }
        // console.log(t);        
      }      
    )    
  }

}
