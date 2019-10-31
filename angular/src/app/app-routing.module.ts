import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ClimbersDetailComponent} from './climbers-detail/climbers-detail.component';
import {FriendsComponent} from './friends/friends.component';
import {ClimbersListComponent} from './climbers-list/climbers-list.component';
import {ClimbingRouteAddComponent} from './climbing-route-add/climbing-route-add.component';
import {ClimbingRouteListComponent} from './climbing-route-list/climbing-route-list.component';
import {ClimbingRouteAroundComponent} from './climbing-route-around/climbing-route-around.component';
import {ClimbingRouteIndoorComponent} from './climbing-route-indoor/climbing-route-indoor.component';
import {ClimbingRouteOutdoorComponent} from './climbing-route-outdoor/climbing-route-outdoor.component';
import {CardAddComponent} from './card-add/card-add.component';
import {CardsListComponent} from './cards-list/cards-list.component';
import {BouldersIndoorComponent} from './boulders-indoor/boulders-indoor.component';
import {BouldersOutdoorComponent} from './boulders-outdoor/boulders-outdoor.component';
import {ContactUsComponent} from './contact-us/contact-us.component';
import {ContactRequestComponent} from './contact-request/contact-request.component';
import {GpsComponent} from './gps/gps.component';
import {PageErrorComponent} from './page-error/page-error.component';
import {ClimberAddComponent} from './climber-add/climber-add.component';
import {ClimberFindComponent} from './climber-find/climber-find.component';
import {UsersComponent} from './users/users.component';
import {UsersListComponent} from './users-list/users-list.component';
import {ClimbersComponent} from './climbers/climbers.component';

const routes: Routes = [
  {path: '', redirectTo: '/users', pathMatch: 'full'},
  {path: 'users', component: UsersComponent},
  {path: 'users/list', component: UsersListComponent},
  {path: 'climbers/detail', component: ClimbersDetailComponent},
  {path: 'climbers/list', component: ClimbersListComponent},
  {path: 'climbers/add', component: ClimberAddComponent},
  {path: 'climbers/find', component: ClimberFindComponent},
  {path: 'climbers/friends', component: FriendsComponent},
  {path: 'climbing-routes/add', component: ClimbingRouteAddComponent},
  {path: 'climbing-routes/list', component: ClimbingRouteListComponent},
  {path: 'climbing-routes/around', component: ClimbingRouteAroundComponent},
  {path: 'climbing-routes/indoor', component: ClimbingRouteIndoorComponent},
  {path: 'climbing-routes/outdoor', component: ClimbingRouteOutdoorComponent},
  {path: 'card/add', component: CardAddComponent},
  {path: 'cards/list', component: CardsListComponent},
  {path: 'boulders/indoor', component: BouldersIndoorComponent},
  {path: 'boulders/outdoor', component: BouldersOutdoorComponent},
  {path: 'contact/us', component: ContactUsComponent},
  {path: 'contact/request', component: ContactRequestComponent},
  {path: 'gps', component: GpsComponent},
  {path: '**', component: PageErrorComponent}
];

// creation des routes pour passer d'un bouton a l'autre
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}

export const routingComponent = [ClimbersComponent, ClimbersDetailComponent, FriendsComponent, ClimbersListComponent,
  ClimbingRouteAddComponent, ClimbingRouteListComponent, ClimbingRouteAroundComponent, ClimbingRouteListComponent,
  ClimbingRouteOutdoorComponent, ClimbingRouteIndoorComponent, CardAddComponent, CardsListComponent,
  BouldersIndoorComponent, BouldersOutdoorComponent, ContactUsComponent, ContactRequestComponent, GpsComponent, PageErrorComponent,
  ClimberAddComponent, ClimberFindComponent, UsersComponent, UsersListComponent];
