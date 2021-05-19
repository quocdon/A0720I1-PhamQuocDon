import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CpCardComponent } from './cp-card.component';

describe('CpCardComponent', () => {
  let component: CpCardComponent;
  let fixture: ComponentFixture<CpCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CpCardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CpCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
