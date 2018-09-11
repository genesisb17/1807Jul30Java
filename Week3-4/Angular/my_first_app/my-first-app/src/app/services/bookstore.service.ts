import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Book } from '../models/book.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookstoreService {

  constructor(private http: HttpClient) { }

  public handleError(error: Response) {
    return Observable.throw(error.statusText);
  }

  public getBooks() {
    return this.http.get<Book[]>('http://localhost:8081/bookstore/books');
  }
}
