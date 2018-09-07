import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Book } from '../models/book.model';
import { Genre } from '../models/genre.model';
import { Observable } from 'rxjs/Observable';

import 'rxjs/Rx';

@Injectable()
export class BookstoreService {

  constructor(private http: HttpClient) {}

  public handleError(error: Response) {
    return Observable.throw(error.statusText);
  }

  public getBooks() {
    return this.http.
      get<Book[]>('http://localhost:8081/bookstore/books');
  }

  public getGenres() {
    return this.http.get<Genre[]>('http://localhost:8081/bookstore/genres');
  }

}
