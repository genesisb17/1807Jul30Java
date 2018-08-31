import { Component, OnInit, ViewChild, Input, EventEmitter, HostListener } from '@angular/core';
import { Reim } from '../../reim';
import { User } from '../../user';
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
  statusTemp: string;
  tempUser: User;

  constructor(private authService: AuthService, private modalService: NgbModal) { }


  ngOnInit() 
  {
    this.loadReim();
  }

  getStatus(id: number): string
  {
    //console.log(this.statusTemp = this.authService.status(id));   
    return this.statusTemp = this.authService.status(id);     
  }

  loadReim()
  {
    if(this.authService.servletData.user_role_id == 1)
    {
      console.log("IN EMPLOYEE GET REIM")
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
            //console.log(this.reimb, data);
        });
    }
  }

  openModal(reimb: Reim)
  {
    this.modal.ModOpen(reimb);
  }

  reload()
  {
    console.log("reload")
    this.loadReim();
  }
}
