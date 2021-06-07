import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Teacher} from '../models/teacher';

@Injectable({
  providedIn: 'root'
})
export class TeacherService {
  API_URL = 'http://localhost:3000/teachers';

  constructor(private http: HttpClient) { }

  getAllTeachers(): Observable<Teacher[]> {
    return this.http.get<Teacher[]>(this.API_URL);
  }
}
