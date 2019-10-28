import {Component} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {MatSliderModule} from '@angular/material/slider';

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
  title = 'ClimbingZone1'
  public firstName = 'test'
  public lastName = 'test1'
  public siteUrl = window.location.href;
  friends: Array<any>;

  constructor(private http: HttpClient) {
  }


  foo() {
    // this.http.get('/api/Friends').subscribe(e => this.friends = e as Array<any>);
    this.http.get('/users').subscribe(e => this.foo());
  }

  greatUser() {
    return  'hello ' + name;

  }

}
