import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CountdownTimerEventComponent } from './countdown-timer-event.component';

describe('CountdownTimerEventComponent', () => {
  let component: CountdownTimerEventComponent;
  let fixture: ComponentFixture<CountdownTimerEventComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CountdownTimerEventComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CountdownTimerEventComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
