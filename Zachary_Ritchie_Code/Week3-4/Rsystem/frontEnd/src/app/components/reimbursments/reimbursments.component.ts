import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../service/auth.service';

@Component({
  selector: 'app-reimbursments',
  templateUrl: './reimbursments.component.html',
  styleUrls: ['./reimbursments.component.css']
})
export class ReimbursmentsComponent implements OnInit 
{
  private amount: number;
  private description: string;
  private typeVal: number;

  constructor(private authService: AuthService) { }

  ngOnInit() 
  {
    console.log(this.typeVal);
  }

  logVal()
  {
    console.log(this.typeVal);
  }

  createReimbursement()
  {
    
    console.log(this.amount + " " + this.description + " " + this.authService.servletData.ers_user_id + " " + this.typeVal);
    this.authService.createReim(this.amount, this.description, this.authService.servletData.ers_user_id, this.typeVal).subscribe(
      data => {
        this.amount = null;
        this.description = null;
        this.typeVal = null;
    });    
  }
}
