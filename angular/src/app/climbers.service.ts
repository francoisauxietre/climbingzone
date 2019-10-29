import {Injectable} from '@angular/core'; // pour la ceration de service injectable
import {HttpClient, HttpErrorResponse} from '@angular/common/http'; // pour parler a api
import {IClimber} from './climber'; // creation de notre interface climber
import {Observable, of} from 'rxjs'; // pour le retour du hhtp.get
import {map, catchError} from 'rxjs/operators'; // pour la gestion des erreur des url
import {ajax} from 'rxjs/ajax';

@Injectable({
  providedIn: 'root'
})
export class ClimbersService {
  private url = 'http://localhost:8080/api/Climber';


  constructor(private http: HttpClient) {
  }

  public getClimbers(): Observable<IClimber []> {
    return this.http.get<IClimber []>(this.url).pipe(
      map(data => {
        if (!data) {
          throw new Error('------------Value expected!------------');
          return data;
        }
        return data;
      }));
  }
}
