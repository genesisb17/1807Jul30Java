import { Component, OnInit } from '@angular/core';
import { BookstoreService } from '../../services/bookstore.service';
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
    this.getBooks();
    this.getGenres();
    console.log('IN BOOK COMPONENT NG ON INIT');
  }

  getGenreById(id: number) {
    return this.genres.filter(g => g.id === id )[0].name;
  }


  // subscribe to observable from book store service
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
