import {Component, OnInit} from '@angular/core';
import {MapsService} from './maps.service';

// component decorateur
@Component({
  selector: 'app-root', // unique nom pour referencer le composant
  templateUrl: './app.component.html', // le template du composant
  styleUrls: ['./app.component.scss'] // le specifique style applique a ce template
})
// logique du composant ici
export class AppComponent implements OnInit{
 title = 'ClimbingZone 2.0';
 latitude = '';
 longitude = '';
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
