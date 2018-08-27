import { Component, OnInit } from '@angular/core';
import { Book } from '../models/book.model';
import { Genre } from '../models/genre.model';
import { BookstoreService } from '../../services/bookstore.service';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})


export class BooksComponent implements OnInit {

  books: Book[] = [];
  genres: Genre[] = [];

  constructor(private bsService: BookstoreService) { }

  ngOnInit() {
    this.getBooks();
  }

  getGenreById() {

  }

  getBooks() {
    this.bsService.getBooks().subscribe(
      t => {
        if (t != null) {
          this.books = t;
          console.log('Loaded books');
        } else {
          console.error('Error loading books');
        }
      }
    );
  }

}
