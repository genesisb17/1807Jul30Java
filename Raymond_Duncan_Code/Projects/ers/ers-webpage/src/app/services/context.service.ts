import { Injectable } from '@angular/core';
import { User } from '../components/models/user';

@Injectable({
  providedIn: 'root'
})
export class ContextService {

  private user: User;
  // private user = <User>{
  //   userID: 0, username: 'rayd123', firstname: 'Raymond', lastname: 'Duncan', email: 'raydunc@gmail.com', companyRole: 'ADMIN'
  //   // userID: 3, username: 'mrt123', companyRole: 'jkl'
  // };

  constructor() { }

  getActiveUser(): User {
    return this.user;
  }

  setActiveUser(user: User) {
    this.user = user;
  }
}
