import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-page-error',
  template: `
    <p>
      This Url doesn't exist in our web server. Could you please correct you Url. THX.
    </p>
  `,
  styles: []
})
export class PageErrorComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
