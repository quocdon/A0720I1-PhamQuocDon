import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CountdownTimerSetTimerComponent } from './countdown-timer-set-timer/countdown-timer-set-timer.component';
import { CountdownTimerRunCountdownComponent } from './countdown-timer-run-countdown/countdown-timer-run-countdown.component';
import { RatingBarComponent } from './rating-bar/rating-bar.component';
import { RatingInputComponent } from './rating-input/rating-input.component';
import {ReactiveFormsModule} from '@angular/forms';
import { HackernewsCreateComponent } from './hackernews-create/hackernews-create.component';
import { HackernewsListComponent } from './hackernews-list/hackernews-list.component';
import { HackernewsLikesComponent } from './hackernews-likes/hackernews-likes.component';
import { HackernewsNavbarComponent } from './hackernews-navbar/hackernews-navbar.component';
import { HackernewsFooterComponent } from './hackernews-footer/hackernews-footer.component';
import { HackernewsComponent } from './hackernews/hackernews.component';

@NgModule({
  declarations: [
    AppComponent,
    CountdownTimerSetTimerComponent,
    CountdownTimerRunCountdownComponent,
    RatingBarComponent,
    RatingInputComponent,
    HackernewsCreateComponent,
    HackernewsListComponent,
    HackernewsLikesComponent,
    HackernewsNavbarComponent,
    HackernewsFooterComponent,
    HackernewsComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        ReactiveFormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
