import {Injectable} from '@angular/core'; // pour la ceration de service injectable
import {HttpClient, HttpErrorResponse} from '@angular/common/http'; // pour parler a api
import {Observable, of} from 'rxjs'; // pour le retour du hhtp.get
import {map, catchError} from 'rxjs/operators'; // pour la gestion des erreur des url

@Injectable({
  providedIn: 'root'
})
export class ClimbersService {
  private url = 'http://spring.auxietre.com/climbers/';


  constructor(private httpclient: HttpClient) {
  }

  // get all climbers
  public getApiClimbers(): Observable<any> {
    return this.httpclient.get(this.url);
  }

  public getApiClimbersByIdClimber(value): Observable<any> {
    return this.httpclient.get(this.url + value);
  }

  public getApiClimbersByFirstName(value): Observable<any> {
    return this.httpclient.get(this.url + value);
  }

  // public postApiClimbers(user: UserApi): Observable<any> {
  //   return this.httpclient.post(this.url3, user);
  // }

}


