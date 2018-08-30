import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../service/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit 
{
  constructor(private authService: AuthService, private router: Router) { }  

  ngOnInit() 
  {
    if(this.authService.servletData == null)
    {
      this.router.navigate(["/home"]);
    }
  }

  logout()
  {
    this.authService.servletData = null;
  }

}
