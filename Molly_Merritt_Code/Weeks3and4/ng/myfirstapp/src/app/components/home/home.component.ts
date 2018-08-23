import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home', // how to access info that's part of this component
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  buttonClass = 'btn btn-warning';
  text = '';
  counter = 0;
  constructor() { }

  ngOnInit() {
  }

  testBinding() {
    ++this.counter;
    this.text = `this is event and property binding! woo!
      --- You've clicked ${this.counter} times`;
    const classes = ['primary', 'secondary', 'success',
      'danger', 'warning', 'info', 'light', 'dark'];
    this.buttonClass =  `btn btn-${classes[this.counter % 8]}`;
  }

}
