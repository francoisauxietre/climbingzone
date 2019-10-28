import {Component, OnInit} from '@angular/core';
import {ClimbersService} from '../climbers.service';

@Component({
  selector: 'app-climbers-list',
  templateUrl: './climbers-list.component.html',
  styleUrls: ['./climbers-list.component.css']
})
export class ClimbersListComponent implements OnInit {

  public climbers = [];

  constructor(private climbersService: ClimbersService) {
  }

  ngOnInit() {
    this.climbers = this.climbersService.getClimbers();
  }

}
