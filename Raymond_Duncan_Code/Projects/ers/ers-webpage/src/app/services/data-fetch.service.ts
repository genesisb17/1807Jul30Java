import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../components/models/user';
import { ReimbTicket } from '../components/models/reimb-ticket';

@Injectable({
  providedIn: 'root'
})
export class DataFetchService {

  constructor(private http: HttpClient) { }

  getReimbs(user: User): Observable<any> {
    return this.http.post<User>('http://localhost:8081/ers/data/reimb', user);
  }

  createReimb(reimbType: number, reimbAmount: number, reimbDescription: string, user: User): Observable<any> {
    const reimbTicket = {
      reimbAmount: reimbAmount,
      reimbType: reimbType,
      reimbDescription: reimbDescription,
      reimbAuthor: user.userID
    };

    console.log('Sending '.concat(JSON.stringify(reimbTicket)));
    return this.http.post<ReimbTicket>('http://localhost:8081/ers/data/newReimb', JSON.stringify(reimbTicket));
  }

  rescindReimb(reimbID: number, reimbAuthor: number) {
    const reimbTicket = {
      reimbID: reimbID,
      reimbAuthor: reimbAuthor
    };

    return this.http.post<ReimbTicket>('http://localhost:8081/ers/data/rescindReimb', JSON.stringify(reimbTicket));
  }

  updateReimb(reimbID: number, reimbResolver: number, approved: Boolean) {
    const reimbTicket = {
      reimbID: reimbID,
      reimbResolver: reimbResolver
    };
    if (approved) {
      console.log('Sending ' + JSON.stringify(reimbTicket));
      return this.http.post<ReimbTicket>('http://localhost:8081/ers/data/approveReimb', JSON.stringify(reimbTicket));
    } else {
      return this.http.post<ReimbTicket>('http://localhost:8081/ers/data/denyReimb', JSON.stringify(reimbTicket));
    }
  }

}
