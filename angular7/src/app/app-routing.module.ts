import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from './home/home.component';
import {ContactComponent} from './contact/contact.component';
import {AboutComponent} from './about/about.component';
import {ClimbingrouteComponent} from './climbingroute/climbingroute.component';
import {MapsComponent} from './maps/maps.component';
import {ClimberComponent} from './climber/climber.component';
import {CardComponent} from './card/card.component';


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'contact', component: ContactComponent},
  {path: 'maps', component: MapsComponent},
  {path: 'about', component: AboutComponent},
  {path: 'climber', component: ClimberComponent},
  {path: 'card', component: CardComponent},
  {path: 'climbingroute', component: ClimbingrouteComponent}
  // {path: 'mail/id', component: MailComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
