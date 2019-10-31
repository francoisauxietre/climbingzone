import {Component, OnInit} from '@angular/core';
import {ClimbersService} from '../api/climbers.service';
import {FriendsService} from '../api/friends.service';
import {ClimbersApi} from '../api/climber-api';

@Component({
  selector: 'app-climbers-detail',
  templateUrl: './climbers-detail.component.html',
  styleUrls: ['./climbers-detail.component.css']
})
export class ClimbersDetailComponent implements OnInit {

  public climbersApi = [];
  public friendsApi = [];


  private friendsNames = [];
  private firstName = '';
  private message = '';
  public index = 0;

  constructor(private climbersApiService: ClimbersService, private friendsApiService: FriendsService) {
  }

  ngOnInit() {
    this.climbersApiService.getApiClimbers()
      .subscribe(
        data => {
          this.climbersApi = data;
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
  //       this.climbersApi.map(climber => {
  //         if (climber.id === num) {
  //           this.friendsNames.push(climber.firstName);
  //         }
  //       });
  //     }
  //   });
  //   return this.friendsNames;
  // }


  getFirstNameByClimberId(index) {

    if (this.climbersApi[index] !== '') {
      return 'null';
    }
    return this.climbersApi[index].firstName;
  }
}


