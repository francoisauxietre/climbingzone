import {Component, OnInit} from '@angular/core';
import {ClimberApi} from '../api/climber-api';


@Component({
  selector: 'app-climbers',
  templateUrl: './climbers.component.html',
  styleUrls: ['./climbers.component.css']
})
export class ClimbersComponent implements OnInit {

  // public climber: IClimber = {
  //   id: 1,
  //   fir: 'francois ',
  //   firstName: 'Auxietre',
  //   birth: Date.now().toString(),
  //
  // };

  // public selectedClimber = this.climber;
  // climbers: any;

  public onSelect(climber) {
    return  'climber ';
  }

  ngOnInit(): void {
  }
}
