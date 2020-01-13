import { Component, OnInit } from '@angular/core';
import {DataService} from '../data.service';

@Component({
  selector: 'app-climber',
  templateUrl: './climber.component.html',
  styleUrls: ['./climber.component.scss']
})
export class ClimberComponent implements OnInit {
  climbers: Object;
  constructor(private data: DataService) { }

  ngOnInit() {
    this.data.getClimbers().subscribe(data => {
      this.climbers = data;
      console.log(this.climbers[0]);
    });
  }

}
