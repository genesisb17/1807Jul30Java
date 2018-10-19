import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-landing',
  templateUrl: './landing.component.html',
  styleUrls: ['./landing.component.css']
})
export class LandingComponent implements OnInit {

  private activeView = 'reimb';

  constructor() { }

  ngOnInit() {
  }

  updateView($event) {
    this.activeView = $event;
  }

}
