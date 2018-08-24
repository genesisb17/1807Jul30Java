import { Component, OnInit } from '@angular/core';

interface TodoItem {
  id: number;
  text: string;
  style: object;
}

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  buttonClass = 'btn-success';
  currentTime: Date;
  color = 'rebeccapurple';
  counter = 0;
  idCounter = 0;
  itemText: string;
  pipeText = '';
  text = 'Some text.';
  todoItems: TodoItem[] = [];

  constructor() {}

  ngOnInit() {
    setInterval(() => (this.currentTime = new Date()), 1000);
  }

  addTodoItem(text: string) {
    this.todoItems.push({ id: this.idCounter++, text, style: {} });
    this.itemText = '';
  }

  removeTodoItem(id: number) {
    this.todoItems.find(i => i.id === id).style = {textDecoration: 'line-through'};
  }

  testEvent() {
    const classes = [
      'primary',
      'secondary',
      'success',
      'danger',
      'warning',
      'info',
      'light',
      'dark',
    ];
    this.counter++;
    this.buttonClass = `btn-${classes[this.counter % classes.length]}`;
  }
}
