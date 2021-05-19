import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterFinalComponent } from './register-final.component';

describe('RegisterFinalComponent', () => {
  let component: RegisterFinalComponent;
  let fixture: ComponentFixture<RegisterFinalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegisterFinalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterFinalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
