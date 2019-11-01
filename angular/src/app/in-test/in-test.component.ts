import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-in-test',
  templateUrl: './in-test.component.html',
  styleUrls: ['./in-test.component.css']
})
export class InTestComponent implements OnInit {
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

  ngOnInit() {
  }

  onClick(event) {
    this.name = event.type;
    console.log(event);
  }

  logMessage(mail) {
    console.log(mail.value);
  }

  sentEvent() {
    this.sentParentEvent.emit('test de retour depuis ENFANT');
    console.log('envoi depuis FILS');
  }
}
