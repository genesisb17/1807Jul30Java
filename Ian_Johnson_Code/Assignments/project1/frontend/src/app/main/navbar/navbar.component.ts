import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnInit {
  expanded = false;

  constructor(private loginService: LoginService, private router: Router) {}

  ngOnInit() {}

  logout() {
    this.loginService.logout().subscribe(() => {
      this.router.navigate(['/login']);
    });
  }

  toggleExpand() {
    this.expanded = !this.expanded;
  }
}
