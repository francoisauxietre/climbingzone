import { Component, OnInit } from '@angular/core';
import {DataService} from '../data.service';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.scss']
})
export class CardComponent implements OnInit {

  cards: Object;
  constructor(private data: DataService) { }

  ngOnInit() {
    this.data.getClimbingCards().subscribe(data => {
      this.cards = data;
      console.log(this.cards[0]);
    });
  }
}
