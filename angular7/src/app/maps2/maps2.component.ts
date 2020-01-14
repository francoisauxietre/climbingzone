import {AfterViewInit, Component, OnInit} from '@angular/core';

import * as esri from 'esri-leaflet';
import * as L from 'leaflet';

// Open Street Map Definition
const layOsm: L.TileLayer = L.tileLayer('http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
  maxZoom: 19,
  attribution: 'Map-Name',
  detectRetina: true
});

@Component({
  selector: 'app-maps2',
  templateUrl: './maps2.component.html',
  styleUrls: ['./maps2.component.scss']
})
export class Maps2Component implements OnInit {

  private map;
  constructor() { }

    // Values to bind to Leaflet Directive
    leafletOptions: L.MapOptions = {
      zoom: 6,
      center: L.latLng(51.163375, 10.447683)
    };
    // baseLayers: {[layerName: string]: L.Layer} = {'openstreetmap': layOsm};
    // layersControlOptions: L.ControlOptions = { position: 'bottomright' };


    ngOnInit() { }

    onMapReady(map: L.Map) {
      setTimeout(() => {
        map.invalidateSize();
      }, 0);
    }

}
//
// import { Component, ElementRef, HostBinding, ViewChild } from '@angular/core';
//
// // Leaflet import
// import * as L from 'leaflet';
// import 'leaflet.markercluster';
// import 'leaflet-rotatedmarker';
//
// @Component({
//   selector: 'app-gis',
//   templateUrl: './gis-desktop.component.html',
//   styleUrls: ['./gis-desktop.component.css']
// })
//
// export class Maps2Component {
//
//   @HostBinding('class') classes = 'flex-column-body';
//
//   MAP: any;
//
//   // Layers
//   LAYER_OSM = {
//     id: 'openstreetmap',
//     name: 'Open Street Map',
//     enabled: true,
//     layer: L.tileLayer('http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
//       maxZoom: 18,
//       attribution: 'Open Street Map'
//     })
//   };
//
//   // Initialise base layers
//   baseLayers = {
//     'Open Street Map': this.LAYER_OSM.layer
//   };
//
//   // Initialise cluster group-list
//   camerasClusterGroup = L.markerClusterGroup({});
//
//   // Initialise the FeatureGroup to store editable layers
//   editableLayers: any = new L.FeatureGroup();
//
//   // Initialise leaflet options
//   options = {
//     zoom: 11,
//     center: L.latLng([56.283883704796445, 44.036083924804586]),
//     layers: [this.LAYER_OSM.layer]
//   };
//
//   // Initialise leaflet draw options
//   drawOptions = {
//     position: 'topright',
//     draw: {
//       polygon: {
//         allowIntersection: false, // Restricts shapes to simple polygons
//         drawError: {
//           color: '#e1e100', // Color the shape will turn when intersects
//           message: '<strong>b<strong>' // Message that will show when intersect
//         },
//         shapeOptions: {
//           color: '#97009c'
//         }
//       },
//       polyline: false,
//       circle: false,
//       circlemarker: false,
//       rectangle: false,
//       marker: false
//     },
//     edit: {
//       featureGroup: this.editableLayers, // REQUIRED!!
//       remove: true
//     }
//   };
//   //
//   // // Booleans
//   // layerControl: any = false;
//   // bIsDestroy = false;
//
//   // constructor(private _coreConfig: CoreConfig,
//   //             private _globalEventsManagerService: GlobalEventsManagerService,
//   //             private _elementRef: ElementRef,
//   //             private _userDataService: UserDataService) {}
//   //
//   // ngOnInit() {}
//   //
//   // onMapReady(map: L.Map) {
//   //   this.MAP = map;
//   //   this.layerControl = L.control.layers(this.baseLayers, {}, { position: 'bottomright' }).addTo(this.MAP);
//   //   this.MAP.zoomControl.setPosition('topright');
//   //   this.renderMovableObjects(electricTrains);
//   // }
//   //
//   // ngOnDestroy() {
//   //   console.warn('DESTROY_MAP_COMPONENT');
//   //   this.bIsDestroy = true;
  // }

// }
