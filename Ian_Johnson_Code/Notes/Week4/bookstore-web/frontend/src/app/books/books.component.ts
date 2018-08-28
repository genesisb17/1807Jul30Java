import { Component, OnInit } from '@angular/core';
import { Book } from '../book';
import { Genre } from '../genre';
import { BooksService } from '../books.service';
import { GenresService } from '../genres.service';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css'],
})
export class BooksComponent implements OnInit {
  books: Book[];
  genres: Genre[];

  constructor(
    private bookService: BooksService,
    private genreService: GenresService
  ) {}

  ngOnInit() {
    this.bookService.getAll().subscribe(books => (this.books = books));
    this.genreService.getAll().subscribe(genres => (this.genres = genres));
  }

  getGenre(id: number): string {
    return this.genres.filter(g => g.id === id)[0].name;
  }
}
