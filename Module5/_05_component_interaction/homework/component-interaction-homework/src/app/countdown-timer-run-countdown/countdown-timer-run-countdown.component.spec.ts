import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CountdownTimerRunCountdownComponent } from './countdown-timer-run-countdown.component';

describe('CountdownTimerRunCountdownComponent', () => {
  let component: CountdownTimerRunCountdownComponent;
  let fixture: ComponentFixture<CountdownTimerRunCountdownComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CountdownTimerRunCountdownComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CountdownTimerRunCountdownComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
