import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ClimbersService {

  Climbers = [{id: 1, firstName: 'fafa', lastName: 'auxietre', age: 47},
    {id: 2, firstName: 'justin', lastName: 'y', age: 15},
    {id: 3, firstName: 'ju elliot', lastName: 'x', age: 15},
    {id: 4, firstName: 'léo', lastName: 'mothais', age: 17}];

  constructor() {
  }

  getClimbers() {
    return this.Climbers;

  }
}
