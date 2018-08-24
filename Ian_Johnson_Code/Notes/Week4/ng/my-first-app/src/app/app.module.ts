import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { SquarerootPipe } from './pipes/squareroot.pipe';

@NgModule({
  declarations: [
    // These are the classes that are related to views. There can be three types
    // of classes listed here: components, directives and pipes.
    AppComponent,
    HomeComponent,
    NavbarComponent,
    SquarerootPipe,
  ],
  // We could have exports here, which are classes that need to be accessible to
  // the components of other modules. However, we will not be making other
  // modules right now.
  imports: [
    // These are our modules whose classes are needed by classes within this
    // current module.
    BrowserModule,
    FormsModule,
  ],
  providers: [
    // These are our services (which use the @Injectable decorator).
  ],
  bootstrap: [
    // This refers to the root component, which is the main view of the Angular
    // app.
    AppComponent,
  ],
})
export class AppModule {}
