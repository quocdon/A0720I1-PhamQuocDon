import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {IResortService} from '../models/resort-service';

@Injectable({
  providedIn: 'root'
})
export class ResortServiceService {
  private rentTypes = ['Giờ', 'Ngày', 'Tháng', 'Năm'];
  private baseUrl = 'http://localhost:3000/resort-services';

  constructor(private http: HttpClient) {
  }

  getAllRentType() {
    return this.rentTypes;
  }

  getAllServices(): Observable<IResortService[]> {
    return this.http.get<IResortService[]>(this.baseUrl);
  }

  getServicesPagination(page, limit): Observable<IResortService[]> {
    return this.http.get<IResortService[]>(this.baseUrl + '?_page=' + page + '&_limit=' + limit);
  }

  getServiceById(id): Observable<IResortService> {
    return this.http.get<IResortService>(this.baseUrl + '/' + id);
  }

  createService(resortService: IResortService): Observable<any> {
    return this.http.post(this.baseUrl, resortService);
  }

  editService(id, resortService: IResortService): Observable<any> {
    return this.http.patch(this.baseUrl + '/' + id, resortService);
  }

  deleteService(id): Observable<any> {
    return this.http.delete(this.baseUrl + '/' + id);
  }


  search(search: string): Observable<IResortService[]> {
    return this.http.get<IResortService[]>(this.baseUrl + '?name_like=' + search);
  }
}
