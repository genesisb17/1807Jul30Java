import { Component, OnInit } from '@angular/core';
import { ContextService } from '../../services/context.service';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {

  private activeUser = this.context.getActiveUser();

  constructor(
    private context: ContextService
  ) { }

  ngOnInit() {
  }

}
