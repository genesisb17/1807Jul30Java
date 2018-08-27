import { Component, OnInit, Input, PipeTransform } from '@angular/core';
import { Observable } from 'rxjs';

export interface TableColumn {
  property: string;
  title: string;
  formatter?: (any) => string;
}

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css'],
})
export class TableComponent<T> implements OnInit {
  @Input()
  columns: TableColumn[];
  @Input()
  data: Observable<T[]>;

  rowData: T[];

  constructor() {}

  ngOnInit() {
    this.data.subscribe(rowData => (this.rowData = rowData));
  }

  formatEntry(row: T, column: TableColumn): string {
    const formatter = column.formatter || (d => d.toString());
    return formatter(row[column.property]);
  }
}
