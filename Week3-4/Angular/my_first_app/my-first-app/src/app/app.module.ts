import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { SquarerootPipe } from './pipes/squareroot.pipe';
import { LoginComponent } from './components/login/login.component';
import { AppRoutingModule } from './app-routing.module';
import { BookstoreComponent } from './components/bookstore/bookstore.component';
import { BooksComponent } from './components/books/books.component';
import { GenresComponent } from './components/genres/genres.component';
import { AuthorsComponent } from './components/authors/authors.component';
import { HttpClientModule } from '@angular/common/http';
import { BookstoreService } from './services/bookstore.service';


@NgModule({
  declarations: [
    /** Declarations array - holds classes that are related to view.
     * There can be three types of classes listed here: componenets,
     * directives, and pipes.
    */
    AppComponent,
    HomeComponent,
    NavbarComponent,
    SquarerootPipe,
    LoginComponent,
    BookstoreComponent,
    BooksComponent,
    GenresComponent,
    AuthorsComponent
  ], /**
  , exports:[]
  classes that need to be accessible to the components
  of other modules. However, we're not making a multi-modular app
  at the moment, so we do not need anything in the exports array
   */
  imports: [
    /**
     */
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [BookstoreService],
  bootstrap: [AppComponent]
})
export class AppModule { }
