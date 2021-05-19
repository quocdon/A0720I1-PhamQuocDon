import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { YoutubePlaylistComponent } from './youtube-playlist.component';

describe('YoutubePlaylistComponent', () => {
  let component: YoutubePlaylistComponent;
  let fixture: ComponentFixture<YoutubePlaylistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ YoutubePlaylistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(YoutubePlaylistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
