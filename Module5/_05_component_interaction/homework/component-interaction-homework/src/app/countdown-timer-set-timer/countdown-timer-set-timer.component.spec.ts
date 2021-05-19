import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CountdownTimerSetTimerComponent } from './countdown-timer-set-timer.component';

describe('CountdownTimerSetTimerComponent', () => {
  let component: CountdownTimerSetTimerComponent;
  let fixture: ComponentFixture<CountdownTimerSetTimerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CountdownTimerSetTimerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CountdownTimerSetTimerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
