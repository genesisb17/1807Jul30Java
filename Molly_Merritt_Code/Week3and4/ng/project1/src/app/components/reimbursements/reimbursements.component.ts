import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-reimbursements',
  templateUrl: './reimbursements.component.html',
  styleUrls: ['./reimbursements.component.css']
})
export class ReimbursementsComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    console.log('reimbursement view');
  }

}
