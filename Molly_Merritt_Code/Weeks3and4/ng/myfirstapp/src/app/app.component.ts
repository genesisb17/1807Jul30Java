import { Component } from '@angular/core';

@Component({  // component decorator
  selector: 'app-root', // root of our application
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Angular 101';
}
