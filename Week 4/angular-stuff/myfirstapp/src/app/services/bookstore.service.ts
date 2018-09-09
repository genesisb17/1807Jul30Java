import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Book } from '../models/book.model';
import { Genre } from '../models/genre.model';

@Injectable()
export class BookstoreService {

  constructor(private http: HttpClient) { }

  ngOnIt(){

  }
  /*method to get books*/
  public getBooks() {
    return this.http.get<Book>('http://localhost:8888/bookstore/books');
  }
}
