import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  buttonClass = "btn btn-warning";
  text = "";
  counter = 0;
  color = '';
  pipeText = "pipeText";
  currentTime: Date;
  newItem = 'New Item...';
  todoList = ['learn andgular', "eat dinner", "make progress on project one"];
  constructor() {
    setInterval(
      () => {
      this.currentTime = new Date;
      }, 1000);
   }

  ngOnInit() {
  }

  testBinding()
  {
    ++this.counter;
    this.text = "This is event binding!";
    const classes = ['primary', 'secondary', 'success', 'danger', 'warning', 'info', 'light', 'dark'];
    this.buttonClass = `btn btn-${classes[this.counter % 8]}`;
  }

  addItem()
  {
    this.todoList.push(this.newItem);
  }

  strike(item)
  {
    this.todoList = this.todoList
  }
}
