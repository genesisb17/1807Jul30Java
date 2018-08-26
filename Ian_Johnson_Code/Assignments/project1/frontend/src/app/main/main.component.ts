import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css'],
})
export class MainComponent implements OnInit {
  constructor(private userService: UserService, private router: Router) {}

  ngOnInit() {
    // Redirect the user to the login page if logged out.
    this.userService.getCurrentUser().subscribe(undefined, () => {
      this.router.navigate(['/login']);
    });
  }
}
