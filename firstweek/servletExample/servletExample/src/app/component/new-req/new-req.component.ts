import { Component, OnInit } from '@angular/core';
import { Reimbursements } from '../../model/reimbursements';
import { AuthService } from '../../service/auth.service';
import { RouterModule, Router } from '@angular/router';

@Component({
  selector: 'app-new-req',
  templateUrl: './new-req.component.html',
  styleUrls: ['./new-req.component.css']
})
export class NewReqComponent implements OnInit {
  newReq: Reimbursements = new Reimbursements();
  constructor(private authService: AuthService,
    private router: Router
  ) { }

  ngOnInit() {
  }

  newRequest() {
     if (this.newReq.amount == null || this.newReq.type == null) {
      alert('Please fill in all fields.');
     } else {
       this.newReq.username = this.authService.user.username;
      this.authService.createNewRequest(this.newReq).subscribe();
          console.log(this.newReq);
            this.router.navigate(['reimbursements']);
     }
  }

}
