import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Book } from '../components/models/book.model';
import { Genre } from '../components/models/genre.model';


@Injectable({
  providedIn: 'root'
})
export class BookstoreService {

  constructor(private http: HttpClient) { }

  public handleError(error: Response) {
    return Observable.throw(error.statusText);
  }

  public getBooks(): Observable<Book[]> {
    return this.http.get<Book[]>('http://localhost:8081/bookstore/books');
  }

  public getGenres() {
    return this.http.get<Genre>('http://localhost:8081/bookstore/genres');
  }
}
