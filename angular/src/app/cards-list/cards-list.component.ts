import { Component, OnInit } from '@angular/core';
import {CardsService} from '../api/service/cards.service';

@Component({
  selector: 'app-cards-list',
  templateUrl: './cards-list.component.html',
  styleUrls: ['./cards-list.component.css']
})
export class CardsListComponent implements OnInit {


  public cardsApi = [];
  constructor(private cardsApiService: CardsService) {

}

  ngOnInit() {
    this.cardsApiService.getApiCards()
      .subscribe(
        data => {
          this.cardsApi = data;
        }
      );
  }

}
