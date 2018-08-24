## How to make an HTTP Request in Angular
1. In your app.module.ts, import HttpClientModule from @angular/common/http, and add HttpClientModule to the imports array of the @NgModule decorator
    ```typescript
    /* Other imports */
    import { HttpClientModule } from '@angular/common/http';

    @NgModule({
        declarations: [],
        imports: [
            ...,
            HttpClientModule,
            ...
        ]
    })
    ```
2. Create a service class, and make sure you decorate it with the @Injectable() decorator. Inside the constructor of the service class, add a private instance of HttpClient module. Inside this class, add a method that makes the http request. 
    * Don't forget to add this service to the providers array in @NgModule!
    ```typescript
    /* In my-service.service.ts */
    import { HttpClient } from '@angular/common/http';
    import { Injectable} from '@angular/core';

    @Injectable()
    export class MyService {

        constructor(private http: HttpClient) {}

        someGetMethod(): Observable<any> {
            return this.http.get<any>('requestUrl');
        }

        somePostMethod(): Observable<any> {
            return this.http.post<any>('requestUrl', {requestBody});
        }
        
        /* So on and so forth */
    }
    ```
    ```typescript
    /* In app.module.ts */
    @NgModule({
        declarations: [],
        imports: [
            ...,
            HttpClientModule,
            ...
        ],
        providers: [MyService] /* This allows Angular to inject the service into any component */
    })
    ```
3. Inject the service into the component you wish to make the HTTP call in, and don't forget to subscribe!
    ```typescript

    @Component({
        selector: 'my-component',
        templateUrl: '.my-component.component.html'
    })
    export class MyComponent {
        
        constructor(private myService: MyService) {}

        callSomeGetMethod() {
            this.myService.someGetMethod().subscribe(
                data => {
                    /* This function handles a successful HTTP call */
                },
                err => {
                    /* This function handles an error */
                }
            );
        }

        callSomePostMethod() {
            this.myService.somePostMethod().subscribe(
                data => {
                    /* This function handles a successful HTTP call */
                },
                err => {
                    /* This function handles an error */
                }
            );
        }
    }
    ```