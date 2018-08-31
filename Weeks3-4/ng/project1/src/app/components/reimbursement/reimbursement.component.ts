import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Reimbursement } from '../../models/reimbursement.model';
import { HttpeeService } from '../../services/httpee.service';

@Component({
  selector: 'app-reimbursement',
  templateUrl: './reimbursement.component.html',
  styleUrls: ['./reimbursement.component.css']
})
export class ReimbursementComponent implements OnInit {

  reimbursements: Reimbursement[] = [];

  newReimbursement: Reimbursement = new Reimbursement();

  approved: "Approved";
  denied: "Denied";
  isApproved: boolean;
  isHidden: boolean;

  reimb_id: number;
  employee_id

  constructor( private router: Router, private httpService: HttpeeService) { 
    console.log('In reimbursement component constructor');
  }

  ngOnInit() {
    this.getAllReimbursements();
    console.log('IN REIMBURSEMENT COMPONENT NG ON INIT');
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
  setDenied(){
    this.isHidden=true;
    this.isApproved = false;
    console.log("denied");
    return this.denied;
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


}
