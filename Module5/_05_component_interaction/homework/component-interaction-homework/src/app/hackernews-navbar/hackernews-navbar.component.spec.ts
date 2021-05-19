import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HackernewsNavbarComponent } from './hackernews-navbar.component';

describe('HackernewsNavbarComponent', () => {
  let component: HackernewsNavbarComponent;
  let fixture: ComponentFixture<HackernewsNavbarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HackernewsNavbarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HackernewsNavbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
