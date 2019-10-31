import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CardsService {
  private url = 'http://localhost:8080/api/Card';

  constructor(private httpclient: HttpClient) {
  }

  public getApiCards(): Observable<any> {
    return this.httpclient.get(this.url);

  }
}
