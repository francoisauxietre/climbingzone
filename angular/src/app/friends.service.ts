import {Injectable} from '@angular/core';
import {ClimbersService} from './climbers.service';

@Injectable({
  providedIn: 'root'
})
export class FriendsService {

  climbers = [];
  friends = [{id: 1, userId: 12, climberId: 11},
    {id: 1, userId: 1, climberId: 2},
    {id: 2, userId: 2, climberId: 3},
    {id: 3, userId: 2, climberId: 4},
    {id: 4, userId: 3, climberId: 2},
    {id: 5, userId: 4, climberId: 5},
    {id: 6, userId: 2, climberId: 6}];

  constructor(private climbersService: ClimbersService) {
  }

  getFriends() {
    return this.friends;
  }


}
