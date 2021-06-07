import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {Student} from '../models/student';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  API_URL = 'http://localhost:3000/students';

  constructor(private http: HttpClient) { }

  getAllStudents(): Observable<Student[]> {
    return this.http.get<Student[]>(this.API_URL);
  }

  getStudentById(id: string): Observable<Student> {
    return this.http.get<Student>(this.API_URL + '/' + id);
  }
  editStudent(id: string, student: Student): Observable<any> {
    return this.http.patch(this.API_URL + '/' + id, student);
  }

  deleteStudent(id: string): Observable<void> {
    return this.http.delete<void>(this.API_URL + '/' + id);
  }
}
