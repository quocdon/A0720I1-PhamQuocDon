import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ResortServiceDetailComponent } from './resort-service-detail.component';

describe('ResortServiceDetailComponent', () => {
  let component: ResortServiceDetailComponent;
  let fixture: ComponentFixture<ResortServiceDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ResortServiceDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ResortServiceDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
