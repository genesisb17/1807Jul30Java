import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-admin-reimbursements',
  templateUrl: './admin-reimbursements.component.html',
  styleUrls: ['./admin-reimbursements.component.css'],
})
export class AdminReimbursementsComponent implements OnInit {
  selectedStatus: string;

  constructor(private route: ActivatedRoute) {}

  ngOnInit() {
    // Subscribe to the child's routes so that we can choose the right tab based
    // on the selected status.
    this.route.firstChild.paramMap.subscribe(
      params => (this.selectedStatus = params.get('status'))
    );
  }
}
