import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {UserApi} from '../user-api';

@Injectable({
  providedIn: 'root'
})
export class UsersService {
  private url = 'https://jsonplaceholder.typicode.com/posts?userId=1';
  private url3 = 'http://localhost:8080/api/Climber/post';

  constructor(private httpclient: HttpClient) {
  }

  public getTestWithUserId(): Observable<any> {
    const userId = new HttpParams().set('userId', '1');
    return this.httpclient.get(this.url, {params: userId});
  }

  public getPost(user: UserApi): Observable<any> {
    console.log('ici', user);
    // const httpOptions = {
    //   headers: new HttpHeaders({
    //     'Content-Type':  'application/json',
    //     Authorization: 'mon-jeton'
    //   })
    // };
    return this.httpclient.post(this.url3,
      {firstName: 'test', lastName: 'te', day: 12, month: 15, year: 12}
    );
  }
}


