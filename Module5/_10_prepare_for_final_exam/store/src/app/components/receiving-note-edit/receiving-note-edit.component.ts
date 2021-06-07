import { Component, OnInit } from '@angular/core';
import {ReceivingNote} from '../../models/receiving-note';
import {ReceivingNoteService} from '../../services/receiving-note.service';
import {ActivatedRoute, Router} from '@angular/router';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';
import {Item} from '../../models/item';
import {ItemService} from '../../services/item.service';
import * as moment from 'moment';

@Component({
  selector: 'app-receiving-note-edit',
  templateUrl: './receiving-note-edit.component.html',
  styleUrls: ['./receiving-note-edit.component.scss']
})
export class ReceivingNoteEditComponent implements OnInit {
  note: ReceivingNote;
  createForm: FormGroup;
  items: Item[] = [];
  validationMessage = {
    'item': [
      {type: 'required', message: 'Please choose item'},
    ],
    'quantity': [
      {type: 'required', message: 'Please input quantity'},
      {type: 'min', message: 'the quantity is greater than 0'}
    ],
    'price': [
      {type: 'required', message: 'Please input price'},
      {type: 'pattern', message: 'Price is integer and greater than 0'}
    ],
    'date': [
      {type: 'required', message: 'Please input date'},
      {type: 'pattern', message: 'Pattern of date is dd/MM/yyyy'},
      {type: 'invalid', message: 'Invalid date'}
    ]
  };

  constructor(private receivingNoteService: ReceivingNoteService,
              private itemService: ItemService,
              private router: Router,
              private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    let id = this.activatedRoute.snapshot.params["id"];
    this.itemService.getAllItems().subscribe(
      data => this.items = data
    );
    this.initForm();
    this.receivingNoteService.getNoteById(id).subscribe(
      data => this.createForm.patchValue(data)
    );
  }
  initForm() {
    this.createForm = new FormGroup({
      id: new FormControl(),
      item: new FormControl('', Validators.required),
      quantity: new FormControl('', Validators.compose([
        Validators.required,
        Validators.min(0)
      ])),
      price: new FormControl('', Validators.compose([
        Validators.required,
        Validators.required,
        Validators.pattern(/^[1-9]\d*$/)
      ])),
      date: new FormControl('', Validators.compose([
        Validators.required,
        Validators.pattern(/^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$/),
        validateDate
      ]))
    });
  }

  onSubmit() {
    if (this.createForm.valid){
      this.receivingNoteService.editNote(this.createForm.value.id, this.createForm.value).subscribe(data => {
        this.router.navigateByUrl('note');
      });
    }
  }

  compareWith(val1, val2) {
    return val1.id === val2.id;
  }
}
function validateDate(formControl: AbstractControl) {
  const inputDate = formControl.value;
  if (moment(inputDate, 'DD/MM/YYYY').isValid()) {
    return null;
  }
  return {invalid: true};
}
