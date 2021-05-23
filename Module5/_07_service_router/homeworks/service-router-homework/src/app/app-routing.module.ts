import { NgModule } from '@angular/core';
import {Routes, RouterModule, PreloadAllModules} from '@angular/router';
import {HomeComponent} from './home/home/home.component';
import {YoutubePlaylistComponent} from './youtube/youtube-playlist/youtube-playlist.component';
import {YoutubePlayerComponent} from './youtube/youtube-player/youtube-player.component';


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'youtube', loadChildren: () => import('./youtube/youtube.module').then(mod => mod.YoutubeModule)},
  {path: 'dictionary', loadChildren: () => import('./dictionary/dictionary.module').then(mod => mod.DictionaryModule)}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {
    preloadingStrategy: PreloadAllModules
  })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
