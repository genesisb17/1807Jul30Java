import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../service/auth.service';
import { User } from '../../model/user';
import { RouterModule, Router } from '@angular/router';
@Component({
  selector: 'app-userinfo',
  templateUrl: './userinfo.component.html',
  styleUrls: ['./userinfo.component.css']
})
export class UserinfoComponent implements OnInit {
  user: User;
  users: User[];
  private isAdmin: boolean;
  constructor(private authService: AuthService,
    private router: Router
  ) { }

  ngOnInit() {
    if (this.authService.user.username === 'admin') {
       this.isAdmin = true;
    }
    this.allUsers();
  }

  allUsers() {
    this.authService.getAllUsers().subscribe (
      data => {
        this.users = data;
        console.log(data);
      }
    );
  }

  create() {
    this.router.navigate(['create']);
  }

}
