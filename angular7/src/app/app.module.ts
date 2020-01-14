import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavComponent } from './nav/nav.component';
import { AboutComponent } from './about/about.component';
import { ContactComponent } from './contact/contact.component';
import { HomeComponent } from './home/home.component';
import {HttpClientModule} from '@angular/common/http';
import { ClimbingrouteComponent } from './climbingroute/climbingroute.component';
import {ReactiveFormsModule} from '@angular/forms';
import {AgmCoreModule} from '@agm/core';
import { MapsComponent } from './maps/maps.component';
import { ClimberComponent } from './climber/climber.component';
import { CardComponent } from './card/card.component';
import { Maps2Component } from './maps2/maps2.component';

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    AboutComponent,
    ContactComponent,
    HomeComponent,
    ClimbingrouteComponent,
    MapsComponent,
    ClimberComponent,
    CardComponent,
    Maps2Component  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    AgmCoreModule.forRoot({apiKey: 'AIzaSyBWYyHJd8a_m4DgrN4J5oEn_mZTg-QOI14'})
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
