import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginStep2Component } from './login-step2.component';

describe('LoginStep2Component', () => {
  let component: LoginStep2Component;
  let fixture: ComponentFixture<LoginStep2Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoginStep2Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginStep2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
