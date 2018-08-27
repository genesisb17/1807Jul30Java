import { Component, OnInit } from '@angular/core';

import { Todo} from '../models/todo.model'

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  private buttonClasses: string[] = ['btn-primary', 'btn-secondary', 'btn-success', 'btn-danger', 'btn-light'];
  buttonCounter = 0;
  buttonClass = 'btn btn-primary'
  text: string = '';
  color: string = 'black';
  pipeText = 'sample text';
  currentTime: Date;
  itemList: string[] = ['One'];
  item = 'New Item...';

  constructor() { 
    setInterval(
      ()=>{
        this.currentTime = new Date;
      }, 1000);
  }

  ngOnInit() {
  }

  testBinding() {
    this.text = 'This is event binding! You\'ve clicked ' + this.buttonCounter++ + " times";
    this.buttonClass = 'btn ' + this.buttonClasses[this.buttonCounter%this.buttonClasses.length];
  }

  addItem() {
    console.log(this.item);
    this.itemList.push(this.item);
    this.item = '';
  }

  strike(item) {
    this.itemList = this.itemList.filter(i => i !==item);
  }

}
