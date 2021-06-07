import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReceivingNoteEditComponent } from './receiving-note-edit.component';

describe('ReceivingNoteEditComponent', () => {
  let component: ReceivingNoteEditComponent;
  let fixture: ComponentFixture<ReceivingNoteEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReceivingNoteEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReceivingNoteEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
