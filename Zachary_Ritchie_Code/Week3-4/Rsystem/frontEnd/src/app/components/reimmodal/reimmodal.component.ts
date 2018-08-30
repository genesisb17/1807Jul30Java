import { Component, OnInit, ViewChild } from '@angular/core';
import { NgbModal, NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Reim } from '../../reim';
import { User } from '../../user';
import { AuthService } from '../../service/auth.service';

@Component({
  selector: 'app-reimmodal',
  templateUrl: './reimmodal.component.html',
  styleUrls: ['./reimmodal.component.css']
})
export class ReimmodalComponent implements OnInit {

  @ViewChild("content")
  content: NgbActiveModal;
  reimburse: Reim;

  constructor(private modalService: NgbModal, private authService: AuthService) { }

  ngOnInit()
  {
  }

  getReim(reimID: number)
  {
    console.log(reimID)
    this.authService.getEmployee(reimID).subscribe();
  }

  ModOpen(reimb: Reim) 
  {
    this.reimburse = reimb;
    this.getReim(this.reimburse.reimb_author)
    this.modalService.open(this.content);
  }

  approved()
  {
    this.authService.managerUpdateReim(this.reimburse.reimb_id, this.authService.servletData.ers_user_id, 4).subscribe();
    this.loadReim();
  }

  denied()
  {
    this.authService.managerUpdateReim(this.reimburse.reimb_id, this.authService.servletData.ers_user_id, 6).subscribe();
    this.loadReim();
  }

  loadReim()
  {
    if(this.authService.servletData.user_role_id == 1)
    {
      this.authService.employeeGetReim(this.authService.servletData.ers_user_id).subscribe(
        data => {
            this.authService.reimData = data;
        });
    }
    else if (this.authService.servletData.user_role_id == 2)
    {
      this.authService.managerGetReim().subscribe(
        data => {
            this.authService.reimData = data;
        });
    }
  }
}
