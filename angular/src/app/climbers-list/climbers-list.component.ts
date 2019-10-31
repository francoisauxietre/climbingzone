import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {ClimbersService} from '../api/service/climbers.service';
import {FriendsService} from '../api/service/friends.service';
import {ClimberApi} from '../api/climber-api';

@Component({
  selector: 'app-climbers-list',
  templateUrl: './climbers-list.component.html',
  styleUrls: ['./climbers-list.component.css']
})

export class ClimbersListComponent implements OnInit {

  public ClimberApi: ClimberApi[];
  public friendsApi = [];
  public color = 'blue';
  public name = '';
  // deux formes d'ecriture possible ici 1 et 2
  @Input() public parentData;
  // @Input('parentData') public parentText;
  // quand on veut envoyer du fils a un parent on le fait sous forme d'event
  @Output() public sentParentEvent = new EventEmitter();

  public lastName = '';
  public hasError = true;
  public displayName = true;
  public hightLightColor = 'orange';
  public titleStyles = {
    color: 'blue',
    fontStyle: 'italic'
  };

  constructor(private ClimberApiService: ClimbersService, private friendsApiService: FriendsService) {
  }
  // TODO verification si data ou il y a une erreur hhtp
  ngOnInit() {
    this.ClimberApiService.getApiClimbers()
      .subscribe(
        data => {
          this.ClimberApi = data;
        }
      );
    this.friendsApiService.getApiFriends()
      .subscribe(
        data => {
          this.friendsApi = data;
        }
      );

  }

  onClick(event) {
    this.name = event.type;
    console.log(event);
  }

  logMessage(mail) {
    console.log(mail.value);
  }

  sentEvent() {
    this.sentParentEvent.emit('test de retour depsui ENFANT');
    console.log('envoi depuis FILS');
  }

}
