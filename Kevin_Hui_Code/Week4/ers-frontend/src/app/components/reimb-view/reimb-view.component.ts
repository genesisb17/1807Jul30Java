import { Component, OnInit } from '@angular/core';
import { Time } from '../../../../node_modules/@angular/common';
import { AuthService } from '../../services/auth.service';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';


@Component({
  selector: 'app-reimb-view',
  templateUrl: './reimb-view.component.html',
  styleUrls: ['./reimb-view.component.css']
})
export class ReimbViewComponent implements OnInit {

  constructor(private authService: AuthService, private route: ActivatedRoute, private router: Router) {

  }

  private rbID: number;
  private amount: number;
  private submitted: Time;
  private resolved: Time;
  private description: string;
  private receipt: Blob;
  private username: string;
  private author: string;
  private resolver: string;
  private status: string;
  private type: string;
  public rbarray: any[];
  public employee: any[];
  private length: number;

  
  servletData: any;
  id: number;
  private sub: any;

  private orderbool: boolean;

  ngOnInit() {

    this.sub = this.route.params.subscribe(params => {
      this.username = params['servletUsername']; // (+) converts string 'id' to a number
      this.getReimbursementsByUser();
      // In a real app: dispatch action to load the details here.
    });
  }

  // submitReimbursement() {
  //   this.authService.submitReimbursement(this.id, this.amount, this.convertType(this.type), this.description).subscribe(
  //     data => {
  //       console.log(data);
  //       this.getReimbursement();
  //     })
  // };


    logout(){
      this.router.navigateByUrl('login');
    }

    getReimbursementsByUser() {
      //console.log(this.username);
      this.authService.getReimbursementsByUser(this.username).subscribe(
        data => {
          console.log(data);


          

          // this.rbID = data.rbID
          // this.servletFirst = data.firstname;
          // this.servletLast = data.lastname;
          // this.servletUsername = data.username;
          // this.servletEmail = data.email;
          // this.servletEmpID = data.empID;
          // this.servletroleID = data.roleID;
        }
      );
 
    }

    getEmployee(){
      this.authService.getAllEmployee().subscribe(
        data => { 
          this.employee = data;
          length = this.employee.length;
  
          console.log(this.employee);
        })
    }
  
    // getEmployeeByID(idd :number){
    //   for(let i = 0; i< length; i++){
    //     if(this.employee[i].empID == idd){
    //       return this.employee[i].firstname + ' ' + this.employee[i].lastname;
    //     }
    //   }
    
    // }
  
  
    // submitReimbursement() {
    //   this.authService.submitReimbursement(this.id, this.amount, this.convertType(this.type), this.description).subscribe(
    //     data => {
    //       console.log(data);
    //       this.getReimbursement();
    //     })
    // };
  
    
    // getReimbursementOrder(order: string) {
    //   if (this.orderbool) {
    //     this.authService.getReimbursementOrder(this.id, order).subscribe(
    //       data => {
  
    //         this.rbarray = data
    //         this.rbID = data.rbID;
    //         this.amount = data.amount;
    //         this.submitted = data.submitted;
    //         this.resolved = data.resolved;
    //         this.description = data.description;
    //         this.receipt = data.receipt;
    //         this.author = data.author;
    //         this.resolver = data.resolver;
    //         this.statusID = data.statusID;
    //         this.typeID = data.typeID;
  
    //         this.orderbool = false;
    //       }
    //     );
    //   }
    //   else {
        
    //     this.authService.getReimbursementOrder(this.id, order + " desc").subscribe(
    //       data => {
  
    //         this.rbarray = data
    //         this.rbID = data.rbID;
    //         this.amount = data.amount;
    //         this.submitted = data.submitted;
    //         this.resolved = data.resolved;
    //         this.description = data.description;
    //         this.receipt = data.receipt;
    //         this.author = data.author;
    //         this.resolver = data.resolver;
    //         this.statusID = data.statusID;
    //         this.typeID = data.typeID;
  
    //         this.orderbool = true;
    //       }
  
    //     );
    //   }
    // }
  }