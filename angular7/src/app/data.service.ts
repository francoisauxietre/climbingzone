import {Injectable} from '@angular/core';

// nouveau decorateur qui precise que le service sera injectable
@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor() {
  }

  firstClickService() {
    console.log('service');
  }
}
