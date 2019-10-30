import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import {AppRoutingModule, routingComponent} from './app-routing.module';
import {AppComponent} from './app.component';
import {ClimbersComponent} from './climbers/climbers.component';
import {UsersComponent} from './users/users.component';
import {NavigationComponent} from './navigation/navigation.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {_MatMenuDirectivesModule, MatIconModule, MatMenuModule} from '@angular/material';
import {DemoMaterialModule} from '../material-module';
import {FriendsComponent} from './friends/friends.component';
import {ClimbingRouteComponent} from './climbing-route/climbing-route.component';
import {ClimbersService} from './climbers.service';
import {FriendsService} from './friends.service';
import { PageErrorComponent } from './page-error/page-error.component';


@NgModule({
  declarations: [
    AppComponent,
    ClimbersComponent,
    UsersComponent,
    NavigationComponent,
    FriendsComponent,
    ClimbingRouteComponent,
    routingComponent,
    PageErrorComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    BrowserAnimationsModule,
    _MatMenuDirectivesModule,
    MatMenuModule,
    MatIconModule,
    DemoMaterialModule
  ],
  providers: [ClimbersService, FriendsService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
