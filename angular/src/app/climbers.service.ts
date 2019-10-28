import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ClimbersService {

  constructor() {
  }

  getClimbers() {
    return [
      {id: 1, name: 'fa', lastName: 'toto', age: 32},
      {id: 1, name: 'fa', lastName: 'toto', age: 32},
      {id: 1, name: 'fa', lastName: 'toto', age: 32},
      {id: 1, name: 'fa', lastName: 'toto', age: 32}];
  }
}
