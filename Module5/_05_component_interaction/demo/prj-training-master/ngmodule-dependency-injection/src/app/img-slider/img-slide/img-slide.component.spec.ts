import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ImgSlideComponent } from './img-slide.component';

describe('ImgSlideComponent', () => {
  let component: ImgSlideComponent;
  let fixture: ComponentFixture<ImgSlideComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ImgSlideComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ImgSlideComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
