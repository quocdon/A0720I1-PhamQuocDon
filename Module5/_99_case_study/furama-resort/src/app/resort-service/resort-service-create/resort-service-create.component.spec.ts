import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ResortServiceCreateComponent } from './resort-service-create.component';

describe('ResortServiceCreateComponent', () => {
  let component: ResortServiceCreateComponent;
  let fixture: ComponentFixture<ResortServiceCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ResortServiceCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ResortServiceCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
