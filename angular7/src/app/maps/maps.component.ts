import { Component, OnInit } from '@angular/core';
import {MapsService} from '../maps.service';

@Component({
  selector: 'app-maps',
  templateUrl: './maps.component.html',
  styleUrls: ['./maps.component.scss']
})
export class MapsComponent implements OnInit {
  title = 'ClimbingZone 2.0';
  latitude = '';
  longitude = '';
  chezMoiLat = '48.10623565001941';
  chezMoiLong = '-1.697200549999934';
  isticLat = '48.11509732074074'
  isticLong = '-1.6382364428552592'
  location: Object;

  constructor(private mapService: MapsService) {

  }

  ngOnInit() {
    this.mapService.getLocation().subscribe(data => {
      console.log(data);
      this.latitude = data.latitude;
      this.longitude = data.longitude;
    });
  }
}
