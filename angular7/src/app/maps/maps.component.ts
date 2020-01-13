import { Component, OnInit } from '@angular/core';
import {MapsService} from '../maps.service';
import {DataService} from '../data.service';
import {Climbingroute} from '../model/Climbingroute';

import MarkerClusterer from '@google/markerclusterer'
//new MarkerClusterer(map, opt_markers, opt_options)

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
  isticLat = '48.11509732074074';
  isticLong = '-1.6382364428552592';
  location;
  climbingroutes: Climbingroute[];
  typeTerrain = 'terrain';

  constructor(private mapService: MapsService, private dataService: DataService) {

  }

  ngOnInit() {
    this.mapService.getLocation().subscribe(data => {
      console.log(data);
      this.latitude = data.latitude;
      this.longitude = data.longitude;
    });
    this.dataService.getClimbingRoutes().subscribe(data => {
      this.climbingroutes = data;
      console.log(this.climbingroutes[0]);
    });
  }
  roadClick() {
    this.typeTerrain = 'roadmap';
    console.log('clicked');
  }

  satelliteClick() {
    this.typeTerrain = 'satellite';
    console.log('clicked');
  }

  hybridClick() {
    this.typeTerrain = 'hybrid';
    console.log('clicked');
  }

  terrainClick() {
    this.typeTerrain = 'terrain';
    console.log('clicked');
  }

}
