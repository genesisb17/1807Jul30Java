﻿/*
The authentication service is used to login and logout of the application, to login it posts the
users credentials to the api and checks the response for a JWT token, if there is one it means
authentication was successful so the user details including the token are added to local storage.

The logged in user details are stored in local storage so the user will stay logged in if they
refresh the browser and also between browser sessions until they logout. If you don't want the
user to stay logged in between refreshes or sessions the behaviour could easily be changed by storing
user details somewhere less persistent such as session storage or in a property of the authentication
service.
*/

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

import { environment } from '../../environments/environment';

@Injectable()
export class AuthenticationService {
    constructor(private http: HttpClient) { }

    login(username: string, password: string) {
        return this.http.post<any>(`${environment.apiUrl}/users/authenticate`, { username: username, password: password })
            .pipe(map(user => {
                // login successful if there's a jwt token in the response
                if (user && user.token) {
                    // store user details and jwt token in local storage to keep user logged in between page refreshes
                    localStorage.setItem('currentUser', JSON.stringify(user));
                }

                return user;
            }));
    }

    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('currentUser');
    }
}
