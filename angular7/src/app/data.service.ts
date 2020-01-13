import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Climbingroute} from './model/Climbingroute';

// nouveau decorateur qui precise que le service sera injectable
@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private httpClient: HttpClient) {
  }

  firstClickService() {
    console.log('service');
  }
  getClimbers() {
    return this.httpClient.get('http://spring.auxietre.com/climbers/');
  }
  getFriends() {
    return this.httpClient.get('http://spring.auxietre.com/climbers/');
  }
  getClimbingRoutes() {
    return this.httpClient.get<Climbingroute[]>('http://spring.auxietre.com/climbingroutes/');
  }
  getClimbingCards() {
    return this.httpClient.get('http://spring.auxietre.com/cards/');
  }

}
