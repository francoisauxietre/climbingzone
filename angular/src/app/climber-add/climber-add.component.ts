import {Component, OnInit} from '@angular/core';
import {Post} from '../api/post';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http'; // marche comme un service
@Component({
  selector: 'app-climber-add',
  templateUrl: './climber-add.component.html',
  styleUrls: ['./climber-add.component.css']
})
export class ClimberAddComponent {
// export class ClimberAddComponent implements OnInit {
  private url1 = 'https://jsonplaceholder.typicode.com';
  private url3 = 'http://localhost:8080/api/Climber/post';
  // public posts: Observable<Post[]>;
  public posts: any;

  constructor(private httpclient: HttpClient) {
  }

  public getPosts() {
    console.log('pos');
    this.posts = this.httpclient.get(this.url1 + '/posts');
  }

  // constructor(private climberApiService: ClimbersService, private usersApiService: UsersService) {
  // }
  //
  // public Users: UserApi[];
  // private firstName: string;
  // private lastName: string;
  // private birth: Date;
  // private day: number;
  // private month: number;
  // private year: number;
  // private idFromPost: number;
  //
  // ngOnInit() {
  // }
  //
  // createPost() {
  //   const data: Post = {
  //     firstName: 'fa',
  //     lastName: 'te',
  //     day: 12,
  //     month: 12,
  //     year: 12
  //   };
  // }
  //
  // add(firstName, lastName, birth) {
  //   // console.log(birth);
  //   // const birthday = new Date(birth);
  //   // const date1 = birthday.getDate();
  //   // console.log(date1);
  //   const day = new Date(birth).getDate();
  //   const month = new Date(birth).getMonth();
  //   const year = new Date(birth).getFullYear();
  //   this.firstName = firstName;
  //   this.lastName = lastName;
  //   this.birth = birth;
  //   this.day = day;
  //   this.month = month;
  //   this.year = year;
  //   console.log(this.firstName, this.lastName, this.day, this.month, this.year);
  //   const user = new UserApi();
  //   user.day = this.day;
  //   user.month = this.month;
  //   user.year = this.year;
  //   user.firstName = this.firstName;
  //   user.lastName = this.lastName;
  //   console.log(user);
  //   this.climberApiService.getPosts()
  //     .subscribe(
  //       data => {
  //         this.idFromPost = data;
  //       }
  //     );
  // }
}
