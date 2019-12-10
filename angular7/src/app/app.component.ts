import { Component } from '@angular/core';

// component decorateur
@Component({
  selector: 'app-root', // unique nom pour referencer le composant
  templateUrl: './app.component.html', // le template du composant
  styleUrls: ['./app.component.scss'] // le specifique style applique a ce template
})
// logique du composant ici
export class AppComponent {
 title = 'ClimbingZone 2.0';
}
