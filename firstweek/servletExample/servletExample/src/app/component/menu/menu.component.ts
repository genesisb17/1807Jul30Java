import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../service/auth.service';
import { Reimbursements } from '../../model/reimbursements';
import { Router } from '@angular/router';
@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  reim: Reimbursements[] = [];
  constructor(private authService: AuthService,
    private router: Router) { }
  
  ngOnInit() {
  }

  logout() {
    console.log('logout');
    this.authService.logout();
  }

  getReimbursemnts() {
    
   return this.authService.reimbursements();
  }

  hasUser() {
    return this.authService.user != null;
  }

}

