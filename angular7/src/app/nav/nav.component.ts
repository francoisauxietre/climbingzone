import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-nav', // unique nom pour referencer le composant
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.scss']
})
export class NavComponent implements OnInit {

  private appTitle: string; // format de code en typescript inverse par rapport a java et utiliser les :

  constructor() {
  }

  ngOnInit() {
    this.appTitle = 'test';
  }

}
