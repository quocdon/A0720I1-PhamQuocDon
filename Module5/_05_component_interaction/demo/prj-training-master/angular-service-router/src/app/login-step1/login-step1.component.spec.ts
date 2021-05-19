import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginStep1Component } from './login-step1.component';

describe('LoginStep1Component', () => {
  let component: LoginStep1Component;
  let fixture: ComponentFixture<LoginStep1Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoginStep1Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginStep1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
