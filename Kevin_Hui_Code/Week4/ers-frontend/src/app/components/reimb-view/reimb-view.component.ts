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

  private userId: number;

  private reimbId: number;
  private amount: number;
  private submitted: Time;
  private resolved: Time;
  private description: string;
  private receipt: Blob;
  private author: string;
  private resolver: string;
  private status: string;
  private type: string;
  private typeId: number;
  public rbarray: any[];
  public employee: any[];
  private length: number;
  public rtypes: any[];

  ngOnInit() {
    this.userId = this.authService.getUserData()[0];
    if (!this.userId) {
      this.router.navigateByUrl('/login');
    }
    this.route.params.subscribe(params => {
      this.refresh();
      this.getAllReimbType();
    });
  }

  getAllReimbursements() {
    this.authService.getAllReimbursements().subscribe(
      data => {
        console.log(data);
        this.rbarray = data;
      }
    )
  }

  getReimbursementsByUserId() {
    this.authService.getReimbursementsByUserId(this.userId).subscribe(
      data => {
        console.log(data);
        this.rbarray = data;
      }
    );
  }

  getAllReimbType() {
    this.authService.getAllReimbType().subscribe(
      data => {
        this.rtypes = data;
      }
    )
  }

  addReimbursement(){
    this.authService.addReimbursement(this.amount, this.description, this.typeId, this.authService.getUserData()[0]).subscribe(
      data => {
        console.log(data);
        if (data) {
          this.getReimbursementsByUserId();
        } else {
          alert("Fields required!");
        }
      }
    )
  }

  refresh() {
    if(this.authService.getUserData()[1] == 1 || this.authService.getUserData()[1] == 2) {
      this.getAllReimbursements();
    } else {
      this.getReimbursementsByUserId();
    }
  }

  logout() {
    this.authService.clearData();
    this.router.navigateByUrl('/login');
  }
}