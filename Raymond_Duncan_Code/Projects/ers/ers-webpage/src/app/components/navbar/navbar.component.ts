import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Router } from '@angular/router';
import { ContextService } from '../../services/context.service';
import { User } from '../models/user';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  private activeView = 'reimb';
  private activeUser: User;
  private su = false;

  @Output() viewEvent = new EventEmitter<string>();

  constructor(
    private context: ContextService,
    private router: Router
  ) { }

  ngOnInit() {
    this.activeUser = this.context.getActiveUser();
    if (this.activeUser.companyRole === 'ADMIN' || this.activeUser.companyRole === 'MANAGER' || this.activeUser.companyRole === 'CEO') {
      this.su = true;
    }
  }

  changeActiveView(view: number) {
    switch (view) {
      case 1:
        this.activeView = 'reimb';
        break;
      case 2:
        this.activeView = 'account';
        break;
      case 3:
        this.activeView = 'create';
        break;
      default:
        break;
    }
    this.viewEvent.emit(this.activeView);
  }

  logout() {
    this.context.setActiveUser(null);
    this.router.navigateByUrl('/home');
  }

}
