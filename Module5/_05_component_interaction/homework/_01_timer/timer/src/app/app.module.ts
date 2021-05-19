import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SetTimerComponent } from './countdown-timer-set-get/set-timer.component';
import {FormsModule} from '@angular/forms';
import { CountdownTimerProcessComponent } from './countdown-timer-process/countdown-timer-process.component';
import { RatingViewComponent } from './rating-view/rating-view.component';
import { RatingBarComponent } from './rating-bar/rating-bar.component';

@NgModule({
  declarations: [
    AppComponent,
    SetTimerComponent,
    CountdownTimerProcessComponent,
    RatingViewComponent,
    RatingBarComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
