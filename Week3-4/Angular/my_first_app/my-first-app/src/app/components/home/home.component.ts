import { Component, OnInit } from '@angular/core';
import {Todo} from '../../models/todo.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  buttonClass = 'btn btn-warning';
  text = 'branches';
  counter = 0;
  color = 'yellow';
  pipeText = 'sample text';

  newItem = 'New Item...';
  currentTime: Date;
  todoList = Todo[];
  constructor() {setInterval(
    () => {
      this.currentTime = new Date;
    }, 1000);
  }
  ngOnInit() {
    this.todoList = [new Todo()];
  }

  testBinding() {
    ++this.counter;
    this.text = 'this is event and property binding! woo!' + `You've clicked ${this.counter} times!`;
    const classes = ['primary', 'secondary', 'success', 'danger', 'warning', 'info', 'light', 'dark'];
    this.buttonClass = `btn btn-${classes[this.counter % 8]}`;
  }

  addItem() {
    this.todoList.push(this.newItem);
  }

  strike(item) {
    this.todoList = this.todoList.filter(i => i !== item);
  }
}
