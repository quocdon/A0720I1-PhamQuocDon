import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HackernewsFooterComponent } from './hackernews-footer.component';

describe('HackernewsFooterComponent', () => {
  let component: HackernewsFooterComponent;
  let fixture: ComponentFixture<HackernewsFooterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HackernewsFooterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HackernewsFooterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
