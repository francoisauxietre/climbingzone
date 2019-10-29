import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ClimbersService {

  Climbers = [{id: 1, firstName: 'fafa', lastName: 'auxietre', age: 47},
    {id: 2, firstName: 'justin', lastName: 'y', age: 15},
    {id: 3, firstName: 'ju elliot', lastName: 'x', age: 15},
    {id: 4, firstName: 'léo', lastName: 'mothais', age: 17},
    {id: 5, firstName: 'justin', lastName: 'y', age: 15},
    {id: 6, firstName: 'judith', lastName: 'x', age: 15},
    {id: 7, firstName: 'mika', lastName: 'pouliquen', age: 17},
    {id: 8, firstName: 'justine', lastName: 'y', age: 15},
    {id: 9, firstName: 'gabin', lastName: 'x', age: 15},
    {id: 10, firstName: 'johnny', lastName: 'mothais', age: 17},
    {id: 11, firstName: 'jules', lastName: 'y', age: 15},
    {id: 12, firstName: 'marie juliette', lastName: 'x', age: 15},
    {id: 13, firstName: 'amandine', lastName: 'vv', age: 17}];

  constructor() {
  }

  getClimbers() {
    return this.Climbers;
  }

}
