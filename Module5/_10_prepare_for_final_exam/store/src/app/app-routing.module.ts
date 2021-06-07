import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomePageComponent} from './components/home-page/home-page.component';
import {ReceivingNoteListComponent} from './components/receiving-note-list/receiving-note-list.component';
import {ReceivingNoteEditComponent} from './components/receiving-note-edit/receiving-note-edit.component';
import {ReceivingNoteCreateComponent} from './components/receiving-note-create/receiving-note-create.component';


const routes: Routes = [
  {path: '', component: HomePageComponent},
  {path: 'note', component: ReceivingNoteListComponent},
  {path: 'note/edit/:id', component: ReceivingNoteEditComponent},
  {path: 'note/create', component: ReceivingNoteCreateComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
