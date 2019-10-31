import {Component, OnInit} from '@angular/core';
import {ClimbersService} from '../api/climbers.service';
import {UserTest} from '../api/userTest';

@Component({
  selector: 'app-climber-find',
  templateUrl: './climber-find.component.html',
  styleUrls: ['./climber-find.component.css']
})
export class ClimberFindComponent implements OnInit {
  constructor(private climbersApiService: ClimbersService) {
  }

  public climbersApi2 = [];
  public test: UserTest[]; // test en castant la liste
  public value = 0;
  private show = false;
  private showUser = false;
  private firstName = '';

  ngOnInit() {
    // methode pour trouver un grimpeur via son Id
    this.climbersApiService.getApiClimbersByIdClimber(this.value)
      .subscribe(
        data => {
          this.climbersApi2 = [];
          this.climbersApi2.push(data);
          if (data === null) {
            this.show = false;
            this.climbersApi2 = [];
          } else {
            this.show = true;
          }
        }
      );
    // methode pour tester un get avec un userId pour apres verifier une authentification
    this.climbersApiService.getTestWithUserId()
      .subscribe(
        data => {
          this.test = [];
          if (data.length > 1) {
            this.test = data;
            this.showUser = true;
          }
        }
      );
  }

  ngOnInit1() {
    this.climbersApiService.getApiClimbersByFirstName(this.firstName)
      .subscribe(
        data => {
          console.log(data.length);
          if (data.length === 1) {
            this.climbersApi2 = data;
            this.show = true;
            console.log(data);

          }
          if (data.length > 1) {
            this.climbersApi2 = data;
            this.show = true;
          }
          if (data.length === 0) {
            this.climbersApi2 = [];
            this.show = false;
          }
        }
      );
  }

  search(idClimber) {
    console.log(idClimber);
    this.value = Number(idClimber);
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
