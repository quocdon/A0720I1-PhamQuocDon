import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { YoutubePlaylistComponent } from './youtube-playlist/youtube-playlist.component';
import { YoutubePlayerComponent } from './youtube-player/youtube-player.component';
import {RouterModule} from '@angular/router';
import {YoutubeRoutingModule} from './youtube-routing.module';



@NgModule({
  declarations: [YoutubePlaylistComponent, YoutubePlayerComponent],
    imports: [
        CommonModule,
        YoutubeRoutingModule,
        RouterModule
    ]
})
export class YoutubeModule { }
