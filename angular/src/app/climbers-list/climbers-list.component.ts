import {Component, OnInit} from '@angular/core';
import {ClimbersService} from '../api/service/climbers.service';
import {FriendsService} from '../api/service/friends.service';
import {ClimberApi} from '../api/climber-api';

@Component({
  selector: 'app-climbers-list',
  templateUrl: './climbers-list.component.html',
  styleUrls: ['./climbers-list.component.css']
})
export class ClimbersListComponent implements OnInit {
  public ClimberApi: ClimberApi[];
  public friendsApi = [];
  private friendsNames = [];
  private firstName = '';
  private message = '';
  public index = 0;

  constructor(private climbersService: ClimbersService, private friendsApiService: FriendsService) {
  }

  ngOnInit() {
    this.climbersService.getApiClimbers()
      .subscribe(
        data => {
          this.ClimberApi = data;
          console.log(data);
          console.log(this.ClimberApi);
        }
      );
    this.friendsApiService.getApiFriends()
      .subscribe(
        data => {
          this.friendsApi = data;
        }
      );
  }

  searchClimbers() {
    console.log('search climbers');
  }

  messageError(message) {
    this.message = message;
    console.log(message);
  }

  getFriendsNameById(index) {
    this.friendsApi.map(obj => {
      if (index === obj.userId) {
        const num = obj.climberId;
        this.ClimberApi.map(climber => {
          if (climber.id === num) {
            this.friendsNames.push(climber.firstName);
          }
        });
      }
    });
    return this.friendsNames;
  }

}


