import { Component, OnInit } from '@angular/core';
import { Reimbursement } from '../../models/reimbursement.model';
import { HttpeeService } from '../../services/httpee.service';
import { LoginService } from '../../services/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-new-reimbursement',
  templateUrl: './new-reimbursement.component.html',
  styleUrls: ['./new-reimbursement.component.css']
})
export class NewReimbursementComponent implements OnInit {

  private amount: number;
  private description: string;
  private type_id: string;

  types: String[] = ["Lodging","Travel","Food","Other"];
  statuses: String[] = ["Pending","Approved","Denied"];
  addNewVisible = false;

  public questions: Array<{ text: string, answer: number, choices: Array<{typeId: number, typeText: string}> }>

  //get current employee
  //use httpeeservice for current employee

  constructor(private router: Router, private httpService: HttpeeService) {} 

  ngOnInit() {
  }

  typeConvert(type: string){
    console.log("in convert");
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
  addNewReimbursement(){
    console.log("in add NewReimbursement")
    console.log(this.typeConvert(this.type_id) + " type");
    console.log(this.amount + this.description + this.httpService.temp.employee_id, this.typeConvert(this.type_id));
    this.httpService.addReimbursement(this.amount,this.description,this.httpService.temp.employee_id,this.typeConvert(this.type_id)).subscribe();
    this.amount = null;
    this.description = null;
    this.type_id = null;
    return this.goToTransition();
  }
  goToTransition(){
    this.router.navigate(['transition']);
  }

  addNewView(){
    this.addNewVisible = !this.addNewVisible;
  }

}
