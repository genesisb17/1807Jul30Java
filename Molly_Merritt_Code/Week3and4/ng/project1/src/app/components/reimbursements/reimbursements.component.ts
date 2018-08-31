import { Component, OnInit } from '@angular/core';
import { Timestamp } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import { Reimbursement } from '../../model/reimbursement.model';

@Component({
  selector: 'app-reimbursements',
  templateUrl: './reimbursements.component.html',
  styleUrls: ['./reimbursements.component.css']
})
export class ReimbursementsComponent implements OnInit {

  reimbursements: Reimbursement[] = [];

  private username: string;
  private password: string;

  private reimbId: string;
  private reimbAuthor: string; // number;
  private reimbAmount: string; // number;
  private reimbSubmitted: string; // Timestamp<Date>;
  private reimbResolved: string; // Timestamp<Date>;
  private reimbDescription: string;
  // private reimbReceipt: Blob;
  private reimbResolver: string; // number;
  private reimbType: string; // number;

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
          // console.log('loaded reimbursements');
          console.log(this.reimbursements);
        } else {
          // console.error('Error loading Reimbursements');
        }
        // console.log(t);
      }
    );
  }

  populateReimbursementTable() {
    const row = document.createElement('tr');
    const cell1 = document.createElement('td'); // id
    const cell2 = document.createElement('td'); // author
    const cell3 = document.createElement('td'); // amount
    const cell4 = document.createElement('td'); // submitted
    const cell5 = document.createElement('td'); // resolved
    const cell6 = document.createElement('td'); // description
    // const cell7 = document.createElement('td'); // receipt
    const cell7 = document.createElement('td'); // resolver
    const cell8 = document.createElement('td'); // type

    cell1.innerHTML = this.reimbId;
    cell2.innerHTML = this.reimbAuthor;
    cell3.innerHTML = this.reimbAmount;
    cell4.innerHTML = this.reimbSubmitted;
    cell5.innerHTML = this.reimbResolved;
    cell6.innerHTML = this.reimbDescription;
    cell7.innerHTML = this.reimbResolver;
    cell8.innerHTML = this.reimbType;

    row.appendChild(cell1);
    row.appendChild(cell2);
    row.appendChild(cell3);
    row.appendChild(cell4);
    row.appendChild(cell5);
    row.appendChild(cell6);
    row.appendChild(cell7);
    row.appendChild(cell8);

    document.getElementById('userTable').appendChild(row);
  }

}
