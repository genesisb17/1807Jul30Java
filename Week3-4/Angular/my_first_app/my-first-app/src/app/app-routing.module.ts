import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from './components/home/home.component';
import { BookstoreComponent } from './components/bookstore/bookstore.component';
import { BooksComponent } from './components/books/books.component';
import { GenresComponent } from './components/genres/genres.component';
import { AuthorsComponent } from './components/authors/authors.component';

export const routes: Routes = [
  { path: '', redirectTo: '/main', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'Bookstore', component: BookstoreComponent },
  { path: 'books', component: BooksComponent },
  { path: 'genres', component: GenresComponent },
  { path: 'authors', component: AuthorsComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})

export class AppRoutingModule { }
