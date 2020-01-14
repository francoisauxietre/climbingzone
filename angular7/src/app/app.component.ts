import {Component, OnInit} from '@angular/core';
import {MapsService} from './maps.service';
import {NotifierService} from 'angular-notifier';

// component decorateur
@Component({
  selector: 'app-root', // unique nom pour referencer le composant
  templateUrl: './app.component.html', // le template du composant
  styleUrls: ['./app.component.scss'] // le specifique style applique a ce template
})
// logique du composant ici
export class AppComponent {
  private notifier: NotifierService;

  /**
   * Constructor
   *
   * @param {NotifierService} notifier Notifier service
   */
  public constructor(notifier: NotifierService) {
    this.notifier = notifier;
  }

  /**
   * Show a notification
   *
   * @param {string} type    Notification type
   * @param {string} message Notification message
   */
  public showNotification(type: string, message: string): void {
    this.notifier.notify(type, message);
  }

  /**
   * Hide oldest notification
   */
  public hideOldestNotification(): void {
    this.notifier.hideOldest();
  }

  /**
   * Hide newest notification
   */
  public hideNewestNotification(): void {
    this.notifier.hideNewest();
  }

  /**
   * Hide all notifications at once
   */
  public hideAllNotifications(): void {
    this.notifier.hideAll();
  }

  /**
   * Show a specific notification (with a custom notification ID)
   // tslint:disable-next-line:no-redundant-jsdoc
   * @param type
   * @param message
   * @param id
   */
  public showSpecificNotification(type: string, message: string, id: string): void {
    this.notifier.show({
      id,
      message,
      type
    });
  }

  /**
   * Hide a specific notification (by a given notification ID)
   *
   * @param {string} id Notification ID
   */
  public hideSpecificNotification(id: string): void {
    this.notifier.hide(id);
  }
}
