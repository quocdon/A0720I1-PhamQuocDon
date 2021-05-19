import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewDefaultComponent } from './view-default.component';

describe('ViewDefaultComponent', () => {
  let component: ViewDefaultComponent;
  let fixture: ComponentFixture<ViewDefaultComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewDefaultComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewDefaultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
