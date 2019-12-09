import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import {AppRoutingModule, routingComponent} from './app-routing.module';
import {AppComponent} from './app.component';
import {UsersComponent} from './users/users.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {_MatMenuDirectivesModule, MatIconModule, MatMenuModule} from '@angular/material';
import {DemoMaterialModule} from '../material-module';
import {FriendsComponent} from './friends/friends.component';
import {ClimbingRouteComponent} from './climbing-route/climbing-route.component';
import {ClimbersService} from './api/service/climbers.service';
import {FriendsService} from './api/service/friends.service';
import {PageErrorComponent} from './page-error/page-error.component';
import { InTestComponent } from './in-test/in-test.component';


@NgModule({
  declarations: [
    AppComponent,
    UsersComponent,
    FriendsComponent,
    ClimbingRouteComponent,
    routingComponent,
    PageErrorComponent,
    InTestComponent,
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
  // All available for all components
  // pour une injection de service
  providers: [ClimbersService, FriendsService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
