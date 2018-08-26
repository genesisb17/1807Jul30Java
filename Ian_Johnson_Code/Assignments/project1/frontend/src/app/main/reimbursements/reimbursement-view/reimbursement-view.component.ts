import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-reimbursement-view',
  templateUrl: './reimbursement-view.component.html',
  styleUrls: ['./reimbursement-view.component.css'],
})
export class ReimbursementViewComponent implements OnInit {
  selectedStatus: string;

  constructor(private route: ActivatedRoute) {}

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.selectedStatus = params.get('status');
    });
  }
}
