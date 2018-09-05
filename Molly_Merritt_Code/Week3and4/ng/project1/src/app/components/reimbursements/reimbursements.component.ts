import { Component, OnInit } from '@angular/core';
import { Timestamp } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import { Reimbursement } from '../../model/reimbursement.model';
import { User } from '../../model/user.model';

@Component({
  selector: 'app-reimbursements',
  templateUrl: './reimbursements.component.html',
  styleUrls: ['./reimbursements.component.css']
})
export class ReimbursementsComponent implements OnInit {

  reimbursements: Reimbursement[] = [];
  users: User[] = [];

  // new reimbursement
  private amount: number;
  private description: string;
  private type_id: string;
  message: string;
  types: String[] = ['Lodging', 'Travel', 'Food', 'Other'];
  statuses: String[] = ['Pending', 'Approved', 'Denied'];

  constructor(private route: ActivatedRoute, private http: AuthService) { }

  ngOnInit() {
    console.log('reimbursement view');
    this.getAllReimbursements();
  }

  getAllReimbursements() {
    this.http.getReimbursements().subscribe(
      t => {
        if (t != null) {
          this.reimbursements = t;
          console.log(this.reimbursements);
        } else {}
      }
    );
  }

  addNewReimbursement() {
    if (this.amount <= 0) {
      this.message = 'Please enter a positive amount';
    } else {
      this.http.addReimbursement(this.amount, this.description, this.http.user.user_id,
        this.typeConvert(this.type_id)).subscribe();
    }
  }

  typeConvert(type: string) {
    console.log('in type convert');
    switch (type) {
      case 'Lodging': { return 1; }
      case 'Travel': { return 2; }
      case 'Food': { return 3; }
      default: { return 4; }
    }
  }
}
