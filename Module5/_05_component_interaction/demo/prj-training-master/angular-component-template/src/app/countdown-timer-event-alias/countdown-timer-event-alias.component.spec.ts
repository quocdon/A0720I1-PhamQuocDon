import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CountdownTimerEventAliasComponent } from './countdown-timer-event-alias.component';

describe('CountdownTimerEventAliasComponent', () => {
  let component: CountdownTimerEventAliasComponent;
  let fixture: ComponentFixture<CountdownTimerEventAliasComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CountdownTimerEventAliasComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CountdownTimerEventAliasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
