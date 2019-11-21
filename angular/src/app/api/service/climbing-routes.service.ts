import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClimbingRoutesService {
  private url = 'http://vps541599.ovh.net:8080/climbingroutes/';

  constructor(private httpclient: HttpClient) {
  }

  public getApiClimbingRoutes(): Observable<any> {
    return this.httpclient.get(this.url);
  }
}
