import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private authService: AuthService, private route: ActivatedRoute, private router: Router) { }

  currentFullName: string;

  ngOnInit() {
    this.currentFullName = this.authService.getUserData()[2];
  }

  logout() {
    this.authService.clearData();
    this.router.navigateByUrl('/login');
  }
}
