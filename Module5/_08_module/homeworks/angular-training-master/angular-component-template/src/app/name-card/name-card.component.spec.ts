import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NameCardComponent } from './name-card.component';

describe('NameCardComponent', () => {
  let component: NameCardComponent;
  let fixture: ComponentFixture<NameCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NameCardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NameCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
