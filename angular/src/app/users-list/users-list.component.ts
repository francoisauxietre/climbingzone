import {Component, OnInit} from '@angular/core';
import {ClimbersService} from '../api/service/climbers.service';
import {UserTest} from '../api/user-test';
import {UsersService} from '../api/service/users.service';

@Component({
  selector: 'app-users-list',
  templateUrl: './users-list.component.html',
  styleUrls: ['./users-list.component.css']
})
export class UsersListComponent implements OnInit {
  constructor(private usersApiService: UsersService, private climberApiService: ClimbersService) {
  }

  public userTests: UserTest[]; // test en castant la liste
  public value = 0;
  private show = false;
  private showUser = false;
  private firstName = '';

  ngOnInit() {
    // methode pour tester authentification.
    // this.usersApiService.postApiClimbers(this.userTests)
    //   .subscribe(
    //     data => {
    //       this.userTests = [];
    //       if (data.length >= 1) {
    //         this.userTests = data;
    //         this.showUser = true;
    //       }
    //     }
    //   );
    // methode pour tester un get avec un userId pour apres verifier une authentification
    this.usersApiService.getTestWithUserId()
      .subscribe(
        data => {
          this.userTests = [];
          if (data.length >= 1) {
            this.userTests = data;
            this.showUser = true;
          }
        }
      );
  }

}
