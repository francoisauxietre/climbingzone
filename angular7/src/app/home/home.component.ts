import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  private h1StyleBool = false;
   // users: Object;

  // constructor(private data: DataService) { }

  ngOnInit() {
    // this.data.getUsers().subscribe(data => {
    //   this.users = data
    //   console.log(this.users)
    // })
  }

  firstClick() {
    console.log('clicked');
    this.h1StyleBool = (this.h1StyleBool === true) ? false : true;
  }

}

