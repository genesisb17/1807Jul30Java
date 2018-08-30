import { Component, OnInit, ViewChild } from '@angular/core';
import { Reim } from '../../reim';
import { AuthService } from '../../service/auth.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ReimmodalComponent } from '../reimmodal/reimmodal.component';

@Component({
  selector: 'app-viewreim',
  templateUrl: './viewreim.component.html',
  styleUrls: ['./viewreim.component.css']
})
export class ViewreimComponent implements OnInit {

  @ViewChild(ReimmodalComponent)
  modal: ReimmodalComponent;
  reimb: Reim[];

  constructor(private authService: AuthService, private modalService: NgbModal) { }

  ngOnInit() 
  {
    this.loadReim();
  }

  loadReim()
  {
    if(this.authService.servletData.user_role_id == 1)
    {
      this.authService.employeeGetReim(this.authService.servletData.ers_user_id).subscribe(
        data => {
            this.authService.reimData = data;
            this.reimb = this.authService.reimData;
        });
    }
    else if (this.authService.servletData.user_role_id == 2)
    {
      this.authService.managerGetReim().subscribe(
        data => {
            this.authService.reimData = data;
            this.reimb = this.authService.reimData;
            console.log(this.reimb);
        });
    }
  }

  openModal(reimb: Reim)
  {
    this.modal.ModOpen(reimb);
  }
}
