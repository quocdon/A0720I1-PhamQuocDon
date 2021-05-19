import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HackernewsLikesComponent } from './hackernews-likes.component';

describe('HackernewsLikesComponent', () => {
  let component: HackernewsLikesComponent;
  let fixture: ComponentFixture<HackernewsLikesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HackernewsLikesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HackernewsLikesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
