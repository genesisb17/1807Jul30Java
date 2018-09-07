/*
The auth guard is used to prevent unauthenticated users from accessing restricted routes,
in this example it's used in app.routing.ts to protect the home page route. For more information
about angular 2 guards you can check out this post on the thoughtram blog.

NOTE: While technically it's possible to bypass this client side authentication check by manually
adding a 'currentUser' object to local storage using browser dev tools, this would only give access
to the client side routes/components, it wouldn't give access to any real secure data from the server
api because a valid authentication token (JWT) is required for this.
*/

import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';

@Injectable()
export class AuthGuard implements CanActivate {

    constructor(private router: Router) { }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        if (localStorage.getItem('currentUser')) {
            // logged in so return true
            return true;
        }

        // not logged in so redirect to login page with the return url
        this.router.navigate(['/login'], { queryParams: { returnUrl: state.url }});
        return false;
    }
}