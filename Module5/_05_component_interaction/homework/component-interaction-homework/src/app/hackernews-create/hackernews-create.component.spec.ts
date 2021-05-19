import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HackernewsCreateComponent } from './hackernews-create.component';

describe('HackernewsCreateComponent', () => {
  let component: HackernewsCreateComponent;
  let fixture: ComponentFixture<HackernewsCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HackernewsCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HackernewsCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
