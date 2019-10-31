import {Component} from '@angular/core';
import {HttpClient} from '@angular/common/http';
// metadata sous forme de decorateur de la classe
// templateURL est url de la vue represente la vue
// selector = dans le fichier coorespodant en html tag pour representer le component
//  on aura <app-root></app-root>
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ClimbingZone1';
  public firstName = 'test1------------------';
  public lastName = 'test1';
  public message = '';
  public siteUrl = window.location.href;
  public isDisabled = false;
  public hasError = false;
  public isItalic = true;
  public response;
  public messageClasses = {
    'text-succes': !this.hasError,
    'text-danger': this.hasError,
    'text-special': this.isItalic
  };

  constructor() {
  }

  refresh(): void {
    window.location.reload();
  }
}
