import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ReceivingNote} from '../models/receiving-note';

@Injectable({
  providedIn: 'root'
})
export class ReceivingNoteService {
  API_URL = 'http://localhost:3000/receiving-notes';

  constructor(private http: HttpClient) {
  }

  getAllNotes(): Observable<ReceivingNote[]> {
    return this.http.get<ReceivingNote[]>(this.API_URL);
  }

  getNoteById(id): Observable<ReceivingNote> {
    return this.http.get<ReceivingNote>(this.API_URL + '/' + id);
  }

  saveNote(note: ReceivingNote): Observable<any> {
    return this.http.post(this.API_URL, note);
  }

  editNote(id: string, note: ReceivingNote): Observable<void> {
    return this.http.patch<void>(this.API_URL + '/' + id, note);
  }

  deleteNote(id): Observable<void> {
    return this.http.delete<void>(this.API_URL + '/' + id);
  }
  search(item: string): Observable<ReceivingNote[]> {
    return this.http.get<ReceivingNote[]>(this.API_URL + '?item.name_like=' + item);
  }
}
