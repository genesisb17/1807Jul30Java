import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';
import { Observable } from 'rxjs';

export interface TableColumn {
  property: string;
  title: string;
  formatter?: (value: any) => string;
  comparator?: (e1: any, e2: any) => number;
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
  sortedColumn: { property: string; ascending: boolean };

  constructor() {}

  ngOnInit() {
    this.data.subscribe(rowData => {
      this.rowData = rowData;
      this.sort();
    });
  }

  formatEntry(row: T, column: TableColumn): string {
    const formatter = column.formatter || (d => d.toString());
    return formatter(row[column.property]);
  }

  handleColumnClick(property: string): void {
    if (this.sortedColumn && this.sortedColumn.property === property) {
      this.sortedColumn.ascending = !this.sortedColumn.ascending;
    } else {
      this.sortedColumn = { property, ascending: true };
    }
    this.sort();
  }

  handleRowClick(data: T): void {
    this.rowClick.emit(data);
  }

  private sort(): void {
    if (!this.sortedColumn) {
      return;
    }
    const { property, ascending } = this.sortedColumn;
    // Provide a sensible default comparator.
    const defaultComparator = (a, b) => {
      if (a > b) {
        return 1;
      } else if (a < b) {
        return -1;
      } else {
        return 0;
      }
    };
    const ascendingComparator =
      this.columns.find(col => col.property === property).comparator ||
      defaultComparator;
    // Handle the descending case by flipping the ascending comparator.
    const comparator = ascending
      ? ascendingComparator
      : (a, b) => -ascendingComparator(a, b);
    this.rowData.sort((r1, r2) => comparator(r1[property], r2[property]));
  }
}
