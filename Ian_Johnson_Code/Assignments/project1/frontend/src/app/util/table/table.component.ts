import {
  Component,
  OnInit,
  Input,
  PipeTransform,
  EventEmitter,
  Output,
} from '@angular/core';
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
  @Output()
  rowClick = new EventEmitter<T>();

  rowData: T[];

  constructor() {}

  ngOnInit() {
    this.data.subscribe(rowData => (this.rowData = rowData));
  }

  formatEntry(row: T, column: TableColumn): string {
    const formatter = column.formatter || (d => d.toString());
    return formatter(row[column.property]);
  }

  handleRowClick(data: T): void {
    this.rowClick.emit(data);
  }
}
