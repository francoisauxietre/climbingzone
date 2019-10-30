import {Injectable} from '@angular/core'; // pour la ceration de service injectable
import {HttpClient, HttpErrorResponse} from '@angular/common/http'; // pour parler a api
import {ClimbersApi} from './climber-api'; // creation de notre interface climber
import {Observable, of} from 'rxjs'; // pour le retour du hhtp.get
import {map, catchError} from 'rxjs/operators'; // pour la gestion des erreur des url


@Injectable({
  providedIn: 'root'
})
export class ClimbersService {
  private url = 'http://localhost:8080/api/Climber';

  constructor(private httpclient: HttpClient) {
  }

  public getApiClimbers(): Observable<any> {
    return this.httpclient.get(this.url);

  }
}
