import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ResortServiceEditComponent } from './resort-service-edit.component';

describe('ResortServiceEditComponent', () => {
  let component: ResortServiceEditComponent;
  let fixture: ComponentFixture<ResortServiceEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ResortServiceEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ResortServiceEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
