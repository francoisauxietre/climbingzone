import {Component, OnInit} from '@angular/core';
import {Post} from '../api/post';
import {Observable} from 'rxjs';
import {HttpClient, HttpParams, HttpHeaders} from '@angular/common/http';
import {ClimberApi} from '../api/climber-api'; // marche comme un service
@Component({
  selector: 'app-climber-add',
  templateUrl: './climber-add.component.html',
  styleUrls: ['./climber-add.component.css']
})
export class ClimberAddComponent {
// export class ClimberAddComponent implements OnInit {
  private url1 = 'https://jsonplaceholder.typicode.com';
  private url2 = 'https://jsonplaceholder.typicode.com/test';
  private url3 = 'https://jsonplaceholder.typicode.com/posts?userId=2';
  private url4 = 'http://localhost:8080/api/Climber/test';
  private posts: Observable<any>;
  private newPost: Observable<any>;
  private climberPost: Observable<any>;

  // public posts: Observalble <Post[]>; avant
  constructor(private httpclient: HttpClient) {
  }

  public getPosts() {
    const params = new HttpParams().set('userId', '2');
    const headers = new HttpHeaders().set('Authorization', 'auth-token');
    console.log('pos');
    // bien faire attention que le get du http client correpondent au type de retour
    // this.posts = this.httpclient.get<Post[]>(this.url2, {params});
    this.posts = this.httpclient.get<Post[]>(this.url2, {headers});
  }

  public createPost() {
    const data: Post = {
      id: null,
      userId: 23,
      title: 'my test ',
      body: 'test'
    };
    this.newPost = this.httpclient.post(this.url2, data);
  }

  public createClimber() {
    const data1 = {
      id: '1'
    };
    this.climberPost = this.httpclient.post(this.url4, {});
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
  //   const data: Post1 = {
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
