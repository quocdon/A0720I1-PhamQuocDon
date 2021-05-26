import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {IEmployee} from '../../employee/models/IEmployee';
import {IAttachService} from '../models/attach-service';

@Injectable({
  providedIn: 'root'
})
export class AttachServiceService {
  private baseUrl = 'http://localhost:3000/attach-services';

  constructor(private http: HttpClient) { }

  getAllAttachServices(): Observable<IAttachService[]> {
    return this.http.get<IAttachService[]>(this.baseUrl).pipe();
  }

  getAttachServiceById(id): Observable<IAttachService> {
    return this.http.get<IAttachService>(this.baseUrl + '/' + id);
  }
}
