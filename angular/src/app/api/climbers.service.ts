import {Injectable} from '@angular/core'; // pour la ceration de service injectable
import {HttpClient, HttpParams, HttpErrorResponse} from '@angular/common/http'; // pour parler a api
import {Observable, of} from 'rxjs'; // pour le retour du hhtp.get
import {map, catchError} from 'rxjs/operators'; // pour la gestion des erreur des url
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

  // a faire la methode put
  public put(): Observable<any> {
    return null;
  }
}
