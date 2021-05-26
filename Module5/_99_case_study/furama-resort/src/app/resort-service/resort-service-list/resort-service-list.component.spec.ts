import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ResortServiceListComponent } from './resort-service-list.component';

describe('ResortServiceListComponent', () => {
  let component: ResortServiceListComponent;
  let fixture: ComponentFixture<ResortServiceListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ResortServiceListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ResortServiceListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
