import {Component, OnInit} from '@angular/core';
import {ClimbersService} from '../api/climbers.service';
import {FriendsService} from '../api/friends.service';

@Component({
  selector: 'app-climber-add',
  templateUrl: './climber-add.component.html',
  styleUrls: ['./climber-add.component.css']
})
export class ClimberAddComponent implements OnInit {
  constructor(private climbersApiService: ClimbersService) {
  }

  ngOnInit() {
    this.climbersApiService.put()
      .subscribe(
        data => {
        }
      );
  }
}
