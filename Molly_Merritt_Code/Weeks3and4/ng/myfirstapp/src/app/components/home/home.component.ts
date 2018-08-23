import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home', // how to access info that's part of this component
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
