import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HackernewsComponent } from './hackernews.component';

describe('HackernewsComponent', () => {
  let component: HackernewsComponent;
  let fixture: ComponentFixture<HackernewsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HackernewsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HackernewsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
