import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from './components/home/home.component';
import { BookstoreComponent } from './components/bookstore/bookstore.component';
import { BooksComponent } from './components/books/books.component';
import { GenresComponent } from './components/genres/genres.component';
import { AuthorsComponent } from './components/authors/authors.component';
/*
ROUTES!
Routing is the mechanism used to navigate between views or pages of your
Angular app. Much like a browser manages displaying different plages based
on links clicked, the Angular Router is used to manage such navigation
in your application. It is a module, RouterModule, that defines a service
and special directives and components for use
*/

export const routes: Routes = [
    { path: '', redirectTo: '/home', pathMatch: 'full' },
    { path: 'home', component: HomeComponent },
    { path: 'bookstore', component: BookstoreComponent },
    { path: 'books', component: BooksComponent },
    { path: 'genres', component: GenresComponent },
    { path: 'authors', component: AuthorsComponent }
];

@NgModule({
    imports: [ RouterModule.forRoot(routes)],
    exports: [ RouterModule ]
})
export class AppRoutingModule {}