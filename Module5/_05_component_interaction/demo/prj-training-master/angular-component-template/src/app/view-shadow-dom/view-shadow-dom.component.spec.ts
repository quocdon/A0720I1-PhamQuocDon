import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewShadowDomComponent } from './view-shadow-dom.component';

describe('ViewShadowDomComponent', () => {
  let component: ViewShadowDomComponent;
  let fixture: ComponentFixture<ViewShadowDomComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewShadowDomComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewShadowDomComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
