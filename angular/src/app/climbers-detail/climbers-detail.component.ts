import { Component, OnInit } from '@angular/core';
import {ClimbersService} from '../climbers.service';

@Component({
  selector: 'app-climbers-detail',
  templateUrl: './climbers-detail.component.html',
  styleUrls: ['./climbers-detail.component.css']
})
export class ClimbersDetailComponent implements OnInit {

  public climbers = [];
  constructor(private climbersService: ClimbersService) {
  }

  ngOnInit() {
    this.climbers = this.climbersService.getClimbers();
  }

}
