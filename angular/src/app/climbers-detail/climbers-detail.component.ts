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
  private friendsNames = [];
  private firstName = '';
  public index = 0;

  constructor(private climbersService: ClimbersService, private friendsService: FriendsService) {
  }

  ngOnInit() {
    this.climbers = this.climbersService.getClimbers();
    this.friends = this.friendsService.getFriends();

  }

  getFriendsNameById(index) {
    this.friends.map(obj => {
      if (index === obj.userId) {
        const num = obj.climberId;
        this.climbers.map(climber => {
          if (climber.id === num) {
            this.friendsNames.push(climber.firstName);
          }
        });
      }
    });
    return this.friendsNames;
  }


  getFirstNameByClimberId(index) {
    return this.climbers[index - 1].firstName;
  }
}
