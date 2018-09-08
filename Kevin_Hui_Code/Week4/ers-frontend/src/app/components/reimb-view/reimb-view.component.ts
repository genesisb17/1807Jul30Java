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

  public userId: number;
  public roleId: number;

  public amount: number;
  public submitted: Time;
  public resolved: Time;
  public description: string;
  public receipt: Blob;
  public author: string;
  public resolver: string;
  public status: string;
  public type: string;
  public typeId: number;
  public rbarray: any[];
  public employee: any[];
  public length: number;
  public rtypes: any[];

  ngOnInit() {
    this.userId = this.authService.getUserData()[0];
    this.roleId = this.authService.getUserData()[1];
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

  addReimbursement() {
    this.authService.addReimbursement(this.amount, this.description, this.typeId, this.authService.getUserData()[0]).subscribe(
      data => {
        console.log(data);
        if (data) {
          this.refresh();
        } else {
          alert("Fields required!");
        }
      }
    )
  }

  approveReimbursement(reimbId: number) {
    console.log("Approve " + reimbId);
    this.authService.approveReimbursement(reimbId, this.authService.getUserData()[0]).subscribe(
      data => {
        this.refresh();
      }
    );
  }

  denyReimbursement(reimbId: number) {
    console.log("Deny " + reimbId);
    this.authService.denyReimbursement(reimbId, this.authService.getUserData()[0]).subscribe(
      data => {
        this.refresh();
      }
    );
  }

  refresh() {
    if (this.authService.getUserData()[1] == 1 || this.authService.getUserData()[1] == 2) {
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