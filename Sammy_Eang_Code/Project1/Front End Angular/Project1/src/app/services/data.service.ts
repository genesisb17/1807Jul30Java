import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  public id: number;
  public role: number;
  constructor() { }
}
