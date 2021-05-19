import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CountdownTimerProcessComponent } from './countdown-timer-process.component';

describe('CountdownTimerProcessComponent', () => {
  let component: CountdownTimerProcessComponent;
  let fixture: ComponentFixture<CountdownTimerProcessComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CountdownTimerProcessComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CountdownTimerProcessComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
