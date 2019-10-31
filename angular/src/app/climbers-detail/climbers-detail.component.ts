import {Component, OnInit} from '@angular/core';
import {ClimbersService} from '../api/service/climbers.service';
import {FriendsService} from '../api/service/friends.service';
import {ClimberApi} from '../api/climber-api';

@Component({
  selector: 'app-climbers-detail',
  templateUrl: './climbers-detail.component.html',
  styleUrls: ['./climbers-detail.component.css']
})
export class ClimbersDetailComponent implements OnInit {
  public ClimberApi: ClimberApi[];
  public friendsApi = [];
  private friendsNames = [];
  private firstName = '';
  private message = '';
  public index = 0;

  constructor(private ClimberApiService: ClimbersService, private friendsApiService: FriendsService) {
  }

  ngOnInit() {
    this.ClimberApiService.getApiClimbers()
      .subscribe(
        data => {
          this.ClimberApi = data;
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

  // getFriendsNameById(index) {
  //   this.friendsApi.map(obj => {
  //     if (index === obj.userId) {
  //       const num = obj.climberId;
  //       this.ClimberApi.map(climber => {
  //         if (climber.id === num) {
  //           this.friendsNames.push(climber.firstName);
  //         }
  //       });
  //     }
  //   });
  //   return this.friendsNames;
  // }
  getFirstNameByClimberId(index) {
    // if (this.ClimberApi[index] !== '') {
    //   return 'null';
    // }
    return this.ClimberApi[index].firstName;
  }
}


