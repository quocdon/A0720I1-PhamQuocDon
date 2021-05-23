import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {YoutubePlaylistComponent} from './youtube-playlist/youtube-playlist.component';
import {YoutubePlayerComponent} from './youtube-player/youtube-player.component';


const routes: Routes = [
  {path: '', component: YoutubePlaylistComponent},
  {path: ':id', component: YoutubePlayerComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class YoutubeRoutingModule { }
