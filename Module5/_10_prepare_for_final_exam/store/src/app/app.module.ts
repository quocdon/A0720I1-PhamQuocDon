import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ReceivingNoteListComponent } from './components/receiving-note-list/receiving-note-list.component';
import {HttpClientModule} from '@angular/common/http';
import {NgxPaginationModule} from 'ngx-pagination';
import { HomePageComponent } from './components/home-page/home-page.component';
import { ReceivingNoteCreateComponent } from './components/receiving-note-create/receiving-note-create.component';
import { ReceivingNoteEditComponent } from './components/receiving-note-edit/receiving-note-edit.component';
import {ReactiveFormsModule} from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    ReceivingNoteListComponent,
    HomePageComponent,
    ReceivingNoteCreateComponent,
    ReceivingNoteEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgxPaginationModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
