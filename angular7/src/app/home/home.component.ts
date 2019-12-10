import { Component, OnInit } from '@angular/core';
import {DataService} from '../data.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  private h1StyleBool = false;
  // tslint:disable-next-line:ban-types
   climbers: Object;
   friends: Object;

  // on a donc acces aux methodes de dataService
  constructor(private data: DataService) { }

  // cette methode est auto loadee quand le composant est apelle Angular life cycle hook
  ngOnInit() {
    this.data.getClimbers().subscribe(data => {
     this.climbers = data;
     console.log(this.climbers);
    });
    this.data.getFriends().subscribe(data => {
      this.friends = data;
    });

  }

  firstClick() {
    console.log('clicked');
    this.h1StyleBool = (this.h1StyleBool === true) ? false : true;
    this.data.firstClickService();
  }

}

