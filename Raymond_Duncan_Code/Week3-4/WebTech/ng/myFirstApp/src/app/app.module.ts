import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import { SqrtPipe } from './pipes/sqrt.pipe';
import { LoginComponent } from './src/app/components/login/login.component';
import { AppRoutingModule } from './app-routing.module';
import { BookstoreComponent } from './components/bookstore/bookstore.component';
import { BooksComponent } from './components/books/books.component';
import { AuthorsComponent } from './components/authors/authors.component';
import { GenresComponent } from './components/genres/genres.component';
import { HttpClient } from 'selenium-webdriver/http';
import { BookstoreService } from './services/bookstore.service';

@NgModule({
  declarations: [
    /* Declaations array - holds chasses that are related to view.
    There can be three types of classes listed here:
     components, directives, and pipes */
    AppComponent,
    HomeComponent,
    NavbarComponent,
    SqrtPipe,
    LoginComponent,
    BookstoreComponent,
    BooksComponent,
    AuthorsComponent,
    GenresComponent
  ],
  /* We can also have exports:[]
  Exports are classes that need to be accessible to the components
  of other modules. However, we're not making a multi-modular app at the 
  moment, so we do not need anyting in teh exports array */
  imports: [
    /* 
    Imports are modules whose classes are needed by classes within this 
    current module */
    BrowserModule,
    FormsModule,
    CommonModule,
    AppRoutingModule,
    HttpClientModule
  ],
  /* Providers are services that use the @injectible keyword */
  providers: [BookstoreService],
  /* Bootstrap refers to the root component which is the main view of the 
  angular app */
  bootstrap: [AppComponent]
})
export class AppModule { }
