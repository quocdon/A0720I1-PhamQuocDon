import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {IEmployee} from '../models/IEmployee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private departments = ['Sales-Marketing', 'Hành chính', 'Phục vụ', 'Quản lý'];
  private positions = ['Lễ tân', 'Phục vụ', 'Chuyên viên', 'Giám sát', 'Quản lý', 'Giám đốc'];
  private degrees = ['Trung cấp', 'Cao đẳng', 'Đại học', 'Sau đại học'];
  private baseUrl = 'http://localhost:3000/employees';

  constructor(private http: HttpClient) {
  }

  getAllDepartments() {
    return this.departments;
  }

  getAllPositions() {
    return this.positions;
  }

  getAllDegrees() {
    return this.degrees;
  }

  getAllEmployees(): Observable<IEmployee[]> {
    return this.http.get<IEmployee[]>(this.baseUrl);
  }

  getEmployeeById(id): Observable<IEmployee> {
    return this.http.get<IEmployee>(this.baseUrl + '/' + id);
  }

  createEmployee(employee: IEmployee): Observable<any> {
    return this.http.post(this.baseUrl, employee);
  }

  editEmployee(id, employee: IEmployee): Observable<any> {
    return this.http.patch(this.baseUrl + '/' + id, employee);
  }

  deleteEmployee(id): Observable<any> {
    return this.http.delete(this.baseUrl + '/' + id);
  }

  search(search: string): Observable<IEmployee[]> {
    return this.http.get<IEmployee[]>(this.baseUrl + '?name_like=' + search);
  }
}
