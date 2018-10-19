import { Component, OnInit } from '@angular/core';
import { FormsModule, FormGroup, FormBuilder } from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import { User } from '../models/user';
import { ContextService } from '../../services/context.service';
import { CompanyRole } from '../enums/company-role';

@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.css']
})
export class CreateAccountComponent implements OnInit {

  private activeUser: User;
  private companyRole: FormGroup;
  private companyRoles = CompanyRole;


  private username: string;
  private password: string;
  private firstname: string;
  private lastname: string;
  private email: string;

  private data: User;

  constructor(
    private authService: AuthService,
    private context: ContextService,
    private fb: FormBuilder
  ) { }

  ngOnInit() {
    this.activeUser = this.context.getActiveUser();
    this.companyRole = this.fb.group({
      companyRoleControl: ['Choose...']
    });
  }

  createAccount() {
    const companyRole = this.companyRole.value.companyRoleControl;

    this.authService.createAccount(this.username, this.password, this.firstname, this.lastname,
      this.email, this.activeUser.userID, companyRole).subscribe(
      data => {
        this.data = data;
        console.log(this.data);
      }
    );
    this.username = '';
    this.password = '';
    this.firstname = '';
    this.lastname = '';
    this.email = '';
  }

}
