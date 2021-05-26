import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ICustomer} from './models/customer';
import {Observable} from 'rxjs';
import {identifierModuleUrl} from '@angular/compiler';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http: HttpClient) {
  }

  private baseUrl = 'http://localhost:3000/customers';

  getAll(): Observable<ICustomer[]> {
    return this.http.get<ICustomer[]>(this.baseUrl);
  }

  getCustomerById(id: string): Observable<ICustomer> {
    return this.http.get<ICustomer>(this.baseUrl + '/' + id);
  }

  createCustomer(customer: ICustomer): Observable<any> {
    return this.http.post(this.baseUrl, customer);
  }

  editCustomer(id: string, customer: ICustomer): Observable<any> {
    return this.http.patch(this.baseUrl + '/' + id, customer);
  }

  deleteCustomer(id: string): Observable<any> {
    return this.http.delete(this.baseUrl + '/' + id);
  }

  search(search: string): Observable<ICustomer[]> {
    return this.http.get<ICustomer[]>(this.baseUrl + '?name_like=' + search);
  }
  checkExist(element: string): Observable<ICustomer[]> {
    return this.http.get<ICustomer[]>(this.baseUrl + '?q=' + element);
  }
}
