import { Component, OnInit } from '@angular/core';
import {NotifierService} from 'angular-notifier';

@Component({
  selector: 'app-notification',
  templateUrl: './notification.component.html',
  styleUrls: ['./notification.component.scss']
})
export class NotificationComponent implements OnInit {

  private readonly notifier: NotifierService;

  constructor(notifierService: NotifierService) {
    this.notifier = notifierService;
  }

  ngOnInit() {
    this.notifier.notify('success', 'You are awesome! I mean it!');
  }
  public showNotification(default1: string, goodEveningYouLovelyPerson: string){

    this.notifier.show({
      type: "success",
      message: "Please Enter your Name",
      id: "THAT_NOTIFICATION_ID" // Again, this is optional
    });
  }
  public hideAllNotifications(): void {
    this.notifier.hideAll();
  }

}
