import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
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


  constructor(private ClimberApiService: ClimbersService, private friendsApiService: FriendsService) {
  }
  // TODO verification si data ou il y a une erreur hhtp
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


}
