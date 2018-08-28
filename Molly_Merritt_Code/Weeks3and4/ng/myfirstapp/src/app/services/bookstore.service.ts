import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Book } from '../models/book.model';
import { Genre } from '../models/genre.model';
import { Observable } from 'rxjs/Observable';

import 'rxjs/Rx'; // importing a lot of stuff

@Injectable({
  providedIn: 'root'
})
export class BookstoreService {

  constructor(private http: HttpClient) { }

  public handleError(error: Response) {
    return Observable.throw(error.statusText);
  }

  public getBooks() { // : Observable<Book[]> {
    return this.http.get<Book[]>('http://localhost:8188/bookstore/books'); // .catch(this.handleError);
  }

  public getGenres() {
    return this.http.get<Genre[]>('http://localhost:8188/bookstore/genres');
  }

}
