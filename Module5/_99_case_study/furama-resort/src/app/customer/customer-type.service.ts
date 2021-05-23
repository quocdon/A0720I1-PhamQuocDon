import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ICustomerType} from './model/customer-type';

@Injectable({
  providedIn: 'root'
})
export class CustomerTypeService {

  constructor(private http: HttpClient) { }
  private baseUrl = 'http://localhost:3000/customerTypes';

  getAll(): Observable<ICustomerType[]>{
    return  this.http.get<ICustomerType[]>(this.baseUrl);
  }
}
