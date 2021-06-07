import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';
import {Item} from '../../models/item';
import * as moment from 'moment';
import {ReceivingNoteService} from '../../services/receiving-note.service';
import {Router} from '@angular/router';
import {ItemService} from '../../services/item.service';

@Component({
  selector: 'app-receiving-note-create',
  templateUrl: './receiving-note-create.component.html',
  styleUrls: ['./receiving-note-create.component.scss']
})
export class ReceivingNoteCreateComponent implements OnInit {
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
              private router: Router) { }

  ngOnInit(): void {
    this.itemService.getAllItems().subscribe(
      data => this.items = data
    );
    this.initForm();
  }

  initForm() {
    this.createForm = new FormGroup({
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
      this.receivingNoteService.saveNote(this.createForm.value).subscribe(data => {
        this.router.navigateByUrl('note');
      });
    }
  }
}
function validateDate(formControl: AbstractControl) {
  const inputDate = formControl.value;
  if (moment(inputDate, 'DD/MM/YYYY').isValid()) {
    return null;
  }
  return {invalid: true};
}
