import { Component, OnInit } from '@angular/core';
import { BookstoreService } from '../../services/bookstore.service';
import { Book } from '../../models/book.model';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})

export class BooksComponent implements OnInit {

  books: Book[] = [];
  constructor(private bsService: BookstoreService) { }

  ngOnInit() {
    this.getBooks();
  }

  getBooks() {
    this.bsService.getBooks().subscribe(
      t => {
        if (t != null) {
          this.books = t;
          console.log('loaded books');
        } else {
          console.error('error on loading books');
        }
      }
    );
  }

}
