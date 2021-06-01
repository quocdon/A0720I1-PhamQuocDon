import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {IEmployee} from '../../employee/models/IEmployee';
import {IContract} from '../models/contract';
import {ICustomer} from '../../customer/models/customer';

@Injectable({
  providedIn: 'root'
})
export class ContractService {
  baseUrl = 'http://localhost:3000/contracts';

  constructor(private http: HttpClient) {
  }

  getAllContracts(): Observable<IContract[]> {
    return this.http.get<IContract[]>(this.baseUrl);
  }

  getContractsPagination(page, limit): Observable<IContract[]> {
    return this.http.get<IContract[]>(this.baseUrl + '?_page=' + page + '&_limit=' + limit);
  }

  getContractById(id): Observable<IContract> {
    return this.http.get<IContract>(this.baseUrl + '/' + id);
  }

  createContract(contract: IContract): Observable<any> {
    return this.http.post(this.baseUrl, contract);
  }

  editContract(id, contract: IContract): Observable<any> {
    return this.http.patch(this.baseUrl + '/' + id, contract);
  }

  deleteContract(id): Observable<any> {
    return this.http.delete(this.baseUrl + '/' + id);
  }

  search(search: string): Observable<IContract[]> {
    return this.http.get<IContract[]>(this.baseUrl + '?id=' + search);
  }
}
