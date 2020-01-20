import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from './home/home.component';
import {ContactComponent} from './contact/contact.component';
import {AboutComponent} from './about/about.component';
import {ClimbingrouteComponent} from './climbingroute/climbingroute.component';
import {MapsComponent} from './maps/maps.component';
import {ClimberComponent} from './climber/climber.component';
import {CardComponent} from './card/card.component';
import {Maps2Component} from './maps2/maps2.component';
import {NotificationComponent} from './notification/notification.component';
import {ChatDialogComponent} from './chat/chat-dialog/chat-dialog.component';


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'contact', component: ContactComponent},
  {path: 'maps', component: MapsComponent},
  {path: 'maps2', component: Maps2Component},
  {path: 'about', component: AboutComponent},
  {path: 'climber', component: ClimberComponent},
  {path: 'card', component: CardComponent},
  {path: 'climbingroute', component: ClimbingrouteComponent},
  {path: 'notification', component: NotificationComponent},
  {path: 'chat', component: ChatDialogComponent},
  // {path: 'mail/id', component: MailComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
