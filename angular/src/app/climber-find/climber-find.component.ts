import {Component, OnInit} from '@angular/core';
import {ClimbersService} from '../api/service/climbers.service';
import {UserTest} from '../api/user-test';
import {ClimberApi} from '../api/climber-api';

@Component({
  selector: 'app-climber-find',
  templateUrl: './climber-find.component.html',
  styleUrls: ['./climber-find.component.css']
})
export class ClimberFindComponent implements OnInit {
  constructor(private ClimberApiService: ClimbersService) {
  }

  public ClimberApi2: ClimberApi[];
  public value = 0;
  private show = false;
  private firstName = '';

  ngOnInit() {
    // methode pour trouver un grimpeur via son Id
    this.ClimberApiService.getApiClimbersByIdClimber(this.value)
      .subscribe(
        data => {
          this.ClimberApi2 = [];
          this.ClimberApi2.push(data);
          if (data === null) {
            this.show = false;
            this.ClimberApi2 = [];
          } else {
            this.show = true;
          }
        }
      );
  }

  ngOnInit1() {
    this.ClimberApiService.getApiClimbersByFirstName(this.firstName)
      .subscribe(
        data => {
          console.log(data.length);
          if (data.length === 1) {
            this.ClimberApi2 = data;
            this.show = true;
            console.log(data);
          }
          if (data.length > 1) {
            this.ClimberApi2 = data;
            this.show = true;
          }
          if (data.length === 0) {
            this.ClimberApi2 = [];
            this.show = false;
          }
        }
      );
  }

  search(id) {
    console.log(id);
    this.value = Number(id);
    this.ngOnInit();
  }

  searchFirstName(firstName) {
    console.log(firstName);
    this.firstName = (firstName);
    if (firstName !== '') {
      this.ngOnInit1();
    }
  }
}
