import {ClimbingRouteApi} from '../api/climbing-route-api';
import {Component, OnInit} from '@angular/core';
import {ClimbingRoutesService} from '../api/service/climbing-routes.service';


@Component({
  selector: 'app-climbing-route-list',
  templateUrl: './climbing-route-list.component.html',
  styleUrls: ['./climbing-route-list.component.css']
})
export class ClimbingRouteListComponent implements OnInit {

  public climbingRouteApis: ClimbingRouteApi[];

  constructor(private climbingRoutesService: ClimbingRoutesService) {
  }

  ngOnInit() {
    this.climbingRoutesService.getApiClimbingRoutes()
      .subscribe(
        data => {
          this.climbingRouteApis = data;
          console.log(data);
          console.log(this.climbingRouteApis);
        }
      );
  }
}
