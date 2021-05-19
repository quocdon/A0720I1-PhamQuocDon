import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CountdownTimerOnchangesComponent } from './countdown-timer-onchanges.component';

describe('CountdownTimerOnchangesComponent', () => {
  let component: CountdownTimerOnchangesComponent;
  let fixture: ComponentFixture<CountdownTimerOnchangesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CountdownTimerOnchangesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CountdownTimerOnchangesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
