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
  url = 'https://www.google.com/maps/place/Rennes/@48.1359463,-1.7085407,13z/data=!4m5!3m4!1s0x480ede2fa7d69085:0x40ca5cd36e4ab30!8m2!3d48.117266!4d-1.6777926'
  title = 'ClimbingZone 2.0';
  latitude = '48.11509732074074';
  longitude = '-1.6382364428552592';
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
