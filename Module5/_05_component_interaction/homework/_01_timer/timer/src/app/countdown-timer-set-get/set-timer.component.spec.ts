import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SetTimerComponent } from './set-timer.component';

describe('SetTimerComponent', () => {
  let component: SetTimerComponent;
  let fixture: ComponentFixture<SetTimerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SetTimerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SetTimerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
