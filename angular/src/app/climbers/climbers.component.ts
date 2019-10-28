import {Component, OnInit} from '@angular/core';
import {Climber} from '../climber';


@Component({
  selector: 'app-climbers',
  templateUrl: './climbers.component.html',
  styleUrls: ['./climbers.component.css']
})
export class ClimbersComponent implements OnInit {

  public climber: Climber = {
    id: 1,
    name: 'francois ',
    firstName: 'Auxietre',
    birth: Date.now(),
    createAt: Date.now(),
    modifyAt: Date.now(),
    deleteAt: Date.now()

  };

  public selectedClimber = this.climber;
  climbers: any;

  public onSelect(climber) {
    return  'climber ';
  }

  ngOnInit(): void {
  }
}
