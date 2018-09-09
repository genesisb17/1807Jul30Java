import { NgModule } from '@angular/core';


import {HomeComponent} from './components/home/home.component';
import {BookStoreComponent} from './components/bookstore/bookstore.component';
import {BooksComponent} from './components/books/books.component';
import {GenresComponent} from './components/genres/genres.component';

export const routes: Routes = [
    {path: '', redirectTo: '/main', pathMatch: 'full'},
    {path: 'home', component: HomeComponent},
    {path: 'bookstore', component: BookstoreComponent},
    { path: 'books', component: BooksComponent},
    {path: 'genres', component: GenresComponent}
];

@NgModule({
    imports: [ RouterModule.forRoot(routes)],
    exports: [ RouterModule ]
})
export class AppRoutingModule{}
