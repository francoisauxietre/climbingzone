import {Injectable} from '@angular/core'; // pour la ceration de service injectable
import {HttpClient, HttpParams, HttpErrorResponse} from '@angular/common/http'; // pour parler a api
import {ClimbersApi} from './climber-api'; // creation de notre interface climber
import {Observable, of} from 'rxjs'; // pour le retour du hhtp.get
import {map, catchError} from 'rxjs/operators'; // pour la gestion des erreur des url


@Injectable({
  providedIn: 'root'
})
export class ClimbersService {
  private url = 'http://localhost:8080/api/Climber';
  private url1 = 'http://localhost:8080/api/Climber/';

  constructor(private httpclient: HttpClient) {
  }

  public getApiClimbers(): Observable<any> {
    return this.httpclient.get(this.url);

  }

  public getApiClimbersByParameter(): Observable<any> {
    const id = 1;
    const climberId = new HttpParams().set('firstName', '/' + id)
    return this.httpclient.get(this.url1, {params: climberId});
  }

}
