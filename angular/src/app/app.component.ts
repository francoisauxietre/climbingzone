import { Component } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { MatSliderModule } from '@angular/material/slider';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angular-escalade';

  friends: Array<any>;
  constructor(private http: HttpClient ) {

  }
  foo() {
  // this.http.get('/api/Friends').subscribe(e => this.friends = e as Array<any>);
  this.http.get('/users').subscribe(e => this.foo());
  }

}
