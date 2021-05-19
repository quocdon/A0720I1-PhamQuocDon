import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PetComponent } from './pet.component';

describe('PetComponent', () => {
  let component: PetComponent;
  let fixture: ComponentFixture<PetComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PetComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
