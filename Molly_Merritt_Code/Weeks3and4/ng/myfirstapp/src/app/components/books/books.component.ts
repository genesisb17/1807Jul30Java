import { Component, OnInit } from '@angular/core';
import { BookstoreService } from 'src/app/services/bookstore.service';
import { Book } from '../../models/book.model';
import { Genre } from '../../models/genre.model';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {
  books: Book[] = [];
  genres: Genre[] = [];

  constructor(private bsService: BookstoreService) {
    console.log('IN BOOK COMPONENT CONSTRUCTOR');
  }

  ngOnInit() {
    console.log('IN BOOK COMPONENT NG ON INIT');
    this.getBooks();
    this.getGenres();
  }

  getGenreById(id: number): string {
    return this.genres.filter(g => g.id === id)[0].name;
  }

  // subscribe to observable from bookstore service
  getBooks() {
    this.bsService.getBooks().subscribe(
      t => {
        if (t != null) {
          this.books = t;
          console.log('loaded books');
        } else {
          console.error('Error loading books');
        }
      }
    );
  }

  getGenres() {
    this.bsService.getGenres().subscribe(
      g => {
        this.genres = g;
      }
    );
  }

}
