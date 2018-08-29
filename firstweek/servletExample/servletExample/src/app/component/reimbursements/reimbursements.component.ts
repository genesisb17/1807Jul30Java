import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../service/auth.service';
import { Time } from '@angular/common';
import { Reimbursements } from '../../model/reimbursements';
import { RouterModule, Router } from '@angular/router';
@Component({
  selector: 'app-reimbursements',
  templateUrl: './reimbursements.component.html',
  styleUrls: ['./reimbursements.component.css']
})
export class ReimbursementsComponent implements OnInit {
  reim: Reimbursements[] = [];
  upReq: Reimbursements = new Reimbursements();
  private isAdmin: boolean;
  private isEmp: boolean;
  private status: string;
  updateReim: Reimbursements;
  constructor(private authService: AuthService,
    private route: Router
  ) { }

  ngOnInit() {
    if (this.authService.user.username === 'admin') {
      this.isAdmin = true;
      this.getAllReimbursements();
    } else {
      this.isEmp = true;
      this.getReimbursements();
    }
  }
getAllReimbursements() {
  this.authService.allReimbursements().subscribe(
    data => {
      if (data != null ) {
        this.reim = data;
        console.log(data);
        console.log('loaded');
      } else {
        console.log('loaded');
      }
   }
  );

}

getReimbursements() {
  this.authService.reimbursements().subscribe(
    data => {
      if (data != null ) {
        this.reim = data;
        console.log(data);
        console.log('loaded');
      } else {
        console.log('loaded');
      }
   }
  );
}

newReimReq() {
  this.route.navigate(['newReim']);
}

updateRequest(rid: number, status: string) {
  if (this.status == null) {
   alert('Please select status.');
  } else {
   this.authService.updateRequest(rid, status).subscribe();
       console.log(this.upReq);
         this.route.navigate(['reimbursements']);
  }
}
}
