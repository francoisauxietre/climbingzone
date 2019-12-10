import { Component, OnInit } from '@angular/core';
import {DataService} from '../data.service';

@Component({
  selector: 'app-climbingroute',
  templateUrl: './climbingroute.component.html',
  styleUrls: ['./climbingroute.component.scss']
})
export class ClimbingrouteComponent implements OnInit {

  climbingroutes: Object;
  constructor(private data: DataService) { }

  ngOnInit() {
    this.data.getClimbingRoutes().subscribe(data => {
      this.climbingroutes = data;
      console.log(this.climbingroutes[0]);
    });
  }
}
