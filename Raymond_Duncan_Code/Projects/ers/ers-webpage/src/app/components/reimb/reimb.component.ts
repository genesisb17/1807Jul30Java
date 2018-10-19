import { Component, OnInit } from '@angular/core';
import { FormsModule, FormGroup, FormBuilder } from '@angular/forms';
import { ReimbTicket } from '../models/reimb-ticket';
import { DataFetchService } from '../../services/data-fetch.service';
import { ContextService } from '../../services/context.service';
import { User } from '../models/user';
import { ReimbType } from '../enums/reimb-type';
import * as $ from 'jquery';

@Component({
  selector: 'app-reimb',
  templateUrl: './reimb.component.html',
  styleUrls: ['./reimb.component.css']
})
export class ReimbComponent implements OnInit {

  private activeUser: User;
  private reimbTickets: ReimbTicket[] = [];
  private su = false;
  private reimbTypes = ReimbType;
  private reimbType: FormGroup;

  private modalTicket: ReimbTicket;
  private modalReimbID = -1;
  private modalReimbType = 0;
  private modalReimbAmount = 0;
  private modalReimbAuthor = 0;
  private modalReimbResolver = 0;
  private modalReimbSubmitted = new Date(2013, 13, 1);
  private modalReimbResolved = new Date(2013, 13, 1);
  private modalReimbStatus = 0;
  private modalReimbDescription = '';

  constructor(
    private dataFetch: DataFetchService,
    private context: ContextService,
    private fb: FormBuilder
  ) { }

  ngOnInit() {
    // this.activeUser = this.context.getActiveUser();
    this.activeUser = this.context.getActiveUser();
    if (this.activeUser.companyRole === 'ADMIN' || this.activeUser.companyRole === 'MANAGER' || this.activeUser.companyRole === 'CEO') {
      this.su = true;
    }
    this.dataFetch.getReimbs(this.activeUser).subscribe(
      data => {
        // console.log(data);
        if (data != null) {
          // Data received!
          this.reimbTickets = data;
        }
      }
    );
    this.reimbType = this.fb.group({
      reimbTypeControl: ['Choose...']
    });

  }

  updateModal(reimbTicket: ReimbTicket) {
    this.modalTicket = reimbTicket;
    this.modalReimbID = reimbTicket.reimbID;
    this.modalReimbType = reimbTicket.reimbType;
    this.modalReimbAmount = reimbTicket.reimbAmount;
    this.modalReimbAuthor = reimbTicket.reimbAuthor;
    this.modalReimbResolver = reimbTicket.reimbResolver;
    this.modalReimbSubmitted = reimbTicket.reimbSubmitted;
    this.modalReimbResolved = reimbTicket.reimbResolved;
    this.modalReimbStatus = reimbTicket.reimbStatus;
    this.modalReimbDescription = reimbTicket.reimbDescription;

  }

  refreshModal() {
    this.modalReimbType = null;
    this.modalReimbAmount = null;
    this.modalReimbAuthor = null;
    this.modalReimbResolver = null;
    this.modalReimbSubmitted = null;
    this.modalReimbResolved = null;
    this.modalReimbStatus = null;
    this.modalReimbDescription = null;
  }

  createTicket() {
    const reimbType = this.reimbType.value.reimbTypeControl - 1;
    const reimbAmount = $('#reimbAmount').val();
    const reimbDescription = $('#reimbDescription').val();

    console.log(reimbType);
    this.dataFetch.createReimb(reimbType, reimbAmount, reimbDescription, this.activeUser).subscribe(
      data => {
        console.log(data);
        this.reimbTickets.push(data);
      }
    );

    $('#reimbAmount').val(0);
    $('#reimbDescription').val('');
  }

  rescindTicket() {
    this.dataFetch.rescindReimb(this.modalReimbID, this.modalReimbAuthor).subscribe(
      data => {
        console.log(data);
        console.log(this.reimbTickets[this.reimbTickets.indexOf(<ReimbTicket>data)]);
        this.reimbTickets[this.reimbTickets.indexOf(<ReimbTicket>data)] = <ReimbTicket> data;
      }
    );
  }

  approveTicket() {
    this.dataFetch.updateReimb(this.modalReimbID, this.modalReimbResolver, true).subscribe(
      data => {
        console.log(data);
        console.log(this.reimbTickets[this.reimbTickets.indexOf(this.modalTicket)]);
        this.reimbTickets[this.reimbTickets.indexOf(this.modalTicket)] = <ReimbTicket> data;
      }
    );
  }

  denyTicket() {
    this.dataFetch.updateReimb(this.modalReimbID, this.modalReimbResolver, false).subscribe(
      data => {
        console.log(data);
        console.log(this.reimbTickets[this.reimbTickets.indexOf(this.modalTicket)]);
        this.reimbTickets[this.reimbTickets.indexOf(this.modalTicket)] = <ReimbTicket> data;
      }
    );
  }

}
