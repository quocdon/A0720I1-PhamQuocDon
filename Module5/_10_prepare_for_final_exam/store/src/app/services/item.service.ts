import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Item} from '../models/item';

@Injectable({
  providedIn: 'root'
})
export class ItemService {
  API_URL = 'http://localhost:3000/items';
  constructor(private http: HttpClient) {
  }

  getAllItems(): Observable<Item[]> {
    return this.http.get<Item[]>(this.API_URL);
  }
}
