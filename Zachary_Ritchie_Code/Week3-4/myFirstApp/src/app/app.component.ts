import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  /*template: `<i> {{title}} </i>
  we are writing this html code inside of our ts file`,*/
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Angular 101';
}
