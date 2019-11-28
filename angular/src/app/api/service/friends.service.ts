import {Injectable} from '@angular/core';
import {ClimbersService} from './climbers.service';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FriendsService {

  private url = 'http://spring.auxietre.com/friends';

  constructor(private httpclient: HttpClient) {
  }

  public getApiFriends(): Observable<any> {
    return this.httpclient.get(this.url);

  }
}
