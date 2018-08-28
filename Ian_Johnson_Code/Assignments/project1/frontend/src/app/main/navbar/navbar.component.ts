import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../login.service';
import { Router } from '@angular/router';
import { UserRole } from '../../user-role.enum';
import { UserService } from '../../user.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnInit {
  expanded = false;
  userRole = UserRole.Employee;

  constructor(
    private loginService: LoginService,
    private userService: UserService,
    private router: Router
  ) {}

  ngOnInit() {
    this.userService
      .getCurrentUser()
      .subscribe(user => (this.userRole = user.role));
  }

  isAdmin(): boolean {
    return this.userRole === UserRole.Manager;
  }

  logout() {
    this.loginService.logout().subscribe(() => {
      this.router.navigate(['/login']);
    });
  }

  toggleExpand() {
    this.expanded = !this.expanded;
  }
}
