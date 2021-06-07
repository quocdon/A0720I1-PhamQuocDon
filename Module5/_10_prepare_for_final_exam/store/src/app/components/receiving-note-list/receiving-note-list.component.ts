import { Component, OnInit } from '@angular/core';
import {ReceivingNote} from '../../models/receiving-note';
import {ReceivingNoteService} from '../../services/receiving-note.service';

@Component({
  selector: 'app-receiving-note-list',
  templateUrl: './receiving-note-list.component.html',
  styleUrls: ['./receiving-note-list.component.scss']
})
export class ReceivingNoteListComponent implements OnInit {
  notes: ReceivingNote[];
  page: number = 1;
  selectedNote: ReceivingNote =  {
    date: '',
    id: 0,
    item: null,
    price: 0,
    quantity: 0,
  };

  constructor(private receivingNoteService: ReceivingNoteService) { }

  ngOnInit(): void {
    this.receivingNoteService.getAllNotes().subscribe(
      data => this.notes = data
    );
  }

  getNote(note: ReceivingNote) {
    this.selectedNote = note;
  }

  delete(id: number) {
    this.receivingNoteService.deleteNote(id).subscribe(
      data => this.ngOnInit()
    );
  }

  search(item) {
    this.page = 1;
    const itemValue = item.value.trim();
    this.receivingNoteService.search(itemValue).subscribe(
      data => this.notes = data
    );
  }
}
