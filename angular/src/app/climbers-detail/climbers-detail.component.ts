import {Component, OnInit} from '@angular/core';
import {ClimbersService} from '../climbers.service';
import {FriendsService} from '../friends.service';

@Component({
  selector: 'app-climbers-detail',
  templateUrl: './climbers-detail.component.html',
  styleUrls: ['./climbers-detail.component.css']
})
export class ClimbersDetailComponent implements OnInit {

  public climbers = [];
  public friends = [];
  private test1 = [];

  constructor(private climbersService: ClimbersService, private friendsService: FriendsService) {
  }

  ngOnInit() {
    this.climbers = this.climbersService.getClimbers();
    this.friends = this.friendsService.getFriends();
  }

// rtouver le nom correspodant a id du grimpeur
//   getFriendsNameById() {
//     this.test1.concat(...)
//     return
//   }

}
