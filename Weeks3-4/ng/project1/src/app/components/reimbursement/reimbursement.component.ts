import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Reimbursement } from '../../models/reimbursement.model';
import { HttpeeService } from '../../services/httpee.service';
import { Employee } from '../../models/employee.model';

@Component({
  selector: 'app-reimbursement',
  templateUrl: './reimbursement.component.html',
  styleUrls: ['./reimbursement.component.css']
})
export class ReimbursementComponent implements OnInit {

  //  - - - - --  - - - - - - - - - - - - - - - - - -
  reimbursements: Reimbursement[] = [];
  employees: Employee[] = [];
  newReimbursement: Reimbursement = new Reimbursement();
  approved: "Approved";
  denied: "Denied";
  isApproved: boolean;
  isHidden: boolean;
  reimb_id: number;

  constructor( private router: Router, private httpService: HttpeeService) { 
    console.log('In reimbursement component constructor');
  }

  ngOnInit() {
    this.getAllReimbursements();
    console.log('IN REIMBURSEMENT COMPONENT NG ON INIT');
    // if(this.httpService.temp != null){
    //   this.getAllEmployees();
    // }
    this.getAllEmployees();
    
  }

  resolveReimbursement(re, status_id){
    let curr = this.reimbursements.find(r => 
      r.reimb_id = re);
    let emp_id = this.httpService.temp.employee_id;
  
    this.httpService.resolveReimbursement(curr.reimb_id, emp_id, status_id).subscribe();
  }
  setApproved(reim){
    this.isApproved = true;
    this.isHidden = true;
    let curr = this.reimbursements.find(r => r.reimb_id = reim);
    
    curr.status_id=2;
    
    this.resolveReimbursement(curr.reimb_id,2);

    console.log(reim + "approved");
    

    return this.goToTransition();
  }
  goToTransition(){
    this.router.navigate(["transition"]);
  }  
  setDenied(reim){
    this.isApproved = false;
    this.isHidden = true;
    let curr = this.reimbursements.find(r => r.reimb_id = reim);
    
    // curr.status_id=2;
    
    this.resolveReimbursement(curr.reimb_id,3);

    console.log(reim + "denied");
    

    return this.goToTransition();
  }
  getAllEmployees(){
    this.httpService.getEmployees().subscribe(
      t => {
        if(t != null){
          this.employees = t;
          console.log('loaded employees');
          console.log(this.employees);
        } else {
          console.error('Error loading Reimbursements');
        }
        // console.log(t);        
      }      
    )
  }

  getAllReimbursements(){
    this.httpService.getReimbursements().subscribe(
      t => {
        if(t != null){
          this.reimbursements = t;
          // console.log('loaded reimbursements');
          console.log(this.reimbursements);
        } else {
          // console.error('Error loading Reimbursements');
        }
        // console.log(t);        
      }      
    )    
  }  

  typeConvert(type: string){
    // console.log("in type convert" );
    switch(type){
      case "Lodging":{
        return 1;
      }
      case "Travel": {
        return 2;
      }
      case "Food":{
        return 3;
      }
      default:{
        return 4;
      }
    }
  }

  statusConvert(stat: number){
    // console.log("in status convert");
    switch(stat){
      case 2:{
        return "Approved";
      }
      case 3: {
        return "Denied";
      }
      default:{
        return "";
      }
    }
  }

  typeConvertString(type: number){
    // console.log("in type convert");
    switch(type){
      case 1:{
        return "Lodging";
      }
      case 2: {
        return "Travel";
      }
      case 3:{
        return "Food";
      }
      default:{
        return "Other";
      }
    }
  }

  getAuthor(author_id){
    // console.log("getting current employee reimbursements");
    // console.log(this.httpService.temp.employee_id + " current employee id");
    // let emp = this.httpService.temp;
    for(var emp of this.employees){
      console.log(" getting author name for author " + author_id + " auth id");
      if(emp.employee_id == author_id){
        return emp.first_name + " " + emp.last_name;
      }
      
    }
  }

  getResolver(resolver_id){
    console.log("employess " + this.employees);
    // let emp = this.httpService.temp;
    for(var emp1 of this.employees){
      console.log(" getting resolver name for reimbursement " + resolver_id + " reimb id");
      console.log(emp1.first_name + " " + emp1.last_name);
      console.log(emp1.employee_id + ": id " + resolver_id + ": res id");
      if(emp1.employee_id == resolver_id){        
        return emp1.first_name + " " + emp1.last_name;
      } else{
        return "-";
      }
      
    }
  }
}
