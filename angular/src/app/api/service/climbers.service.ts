import {Injectable} from '@angular/core'; // pour la ceration de service injectable
import {HttpClient, HttpErrorResponse} from '@angular/common/http'; // pour parler a api
import {Observable, of} from 'rxjs'; // pour le retour du hhtp.get
import {map, catchError} from 'rxjs/operators'; // pour la gestion des erreur des url
import {ClimberApi} from '../climber-api';
import {UserApi} from '../user-api';
import {Post1} from '../post1';

@Injectable({
  providedIn: 'root'
})
export class ClimbersService {
  private url = 'http://localhost:8080/api/Climber';
  private url1 = 'http://localhost:8080/api/Climber/';
  private url2 = 'http://localhost:8080/api/Climber/firstName/';


  constructor(private httpclient: HttpClient) {
  }

  public getApiClimbers(): Observable<any> {
    return this.httpclient.get(this.url);
  }

  public getApiClimbersByIdClimber(value): Observable<any> {
    return this.httpclient.get(this.url1 + value);
  }

  public getApiClimbersByFirstName(value): Observable<any> {
    return this.httpclient.get(this.url2 + value);
  }

  // public postApiClimbers(user: UserApi): Observable<any> {
  //   return this.httpclient.post(this.url3, user);
  // }

  // a faire la methode post
  // public put(): Observable<any> {
  //   return null;
  // }
}
