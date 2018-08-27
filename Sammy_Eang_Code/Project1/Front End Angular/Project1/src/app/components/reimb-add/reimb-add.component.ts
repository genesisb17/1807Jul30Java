import { Component, OnInit } from '@angular/core';
import { Input } from '@angular/core';

@Component({
  selector: 'app-reimb-add',
  templateUrl: './reimb-add.component.html',
  styleUrls: ['./reimb-add.component.css']
})
export class ReimbAddComponent implements OnInit {

  @Input() showMePartially: boolean;

  constructor() { }

  ngOnInit() {
  }

  addReimb() {}

}
