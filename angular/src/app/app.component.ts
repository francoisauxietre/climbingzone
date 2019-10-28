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
  public id1 = 'testId';
  public firstName = 'test';
  public lastName = 'test1';
  public siteUrl = window.location.href;
  public isDisabled = false;
  public hasError = false;
  public isItalic = true;
  public response;
  public messageClasses = {
    'text-succes': !this.hasError,
    'text-danger': this.hasError,
    'text-special': this.isItalic

  }
  friends: Array<any>;

  constructor(private http: HttpClient) {
  }


  foo() {
    // this.http.get('/api/Friends').subscribe(e => this.friends = e as Array<any>);
    // this.response = 'http://localhost:8080/api/Climber'.subscribe(e => this.foo());
    console.log(this.response);
  }

  greatUser() {
    return 'hello ' + name;

  }

  refresh(): void {
    window.location.reload();
  }
}
