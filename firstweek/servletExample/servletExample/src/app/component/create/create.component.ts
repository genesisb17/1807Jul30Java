import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../service/auth.service';
import { RouterModule, Router } from '@angular/router';
import { NewUser } from '../../model/new-user';
@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  newUser: NewUser = new NewUser();
  
  constructor(private authService: AuthService,
    private router: Router
  ) { }

  ngOnInit() {
  }

  backLogin() {
    this.router.navigate(['login']);
  }

  adminuserinfo() {
    this.router.navigate(['userinfo']);
  }

  createUser() {
    if (this.newUser.username == null || this.newUser.password == null || this.newUser.firstname == null || this.newUser.lastname == null || this.newUser.email == null) {
      alert('Please fill in all fields.');
    } else {
      this.authService.createNewUser(this.newUser).subscribe();
          console.log(this.newUser);
            this.router.navigate(['userinfo']);
    }
  }
}


