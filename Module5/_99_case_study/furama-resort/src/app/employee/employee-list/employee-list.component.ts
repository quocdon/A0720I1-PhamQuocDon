import {Component, OnInit} from '@angular/core';
import {IEmployee} from '../models/IEmployee';
import {EmployeeService} from '../service/employee.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.scss']
})
export class EmployeeListComponent implements OnInit {
  employees: IEmployee[];
  page = 1;
  limit = 5;
  nextPage: IEmployee[] = [];
  isSearch = false;
  selectedEmployee: IEmployee = {
    birthday: '',
    degree: '',
    department: '',
    em_id: '',
    email: '',
    id: 0,
    id_card: '',
    name: '',
    phone: '',
    position: ''
  };

  constructor(private employeeService: EmployeeService) {
  }

  ngOnInit(): void {
    this.isSearch = false;
    this.employeeService.getEmployeesPagination(this.page, this.limit).subscribe(data => {
      this.employees = data;
    });
    this.employeeService.getEmployeesPagination(this.page + 1, this.limit).subscribe(data => {
      this.nextPage = data;
    });
  }

  doSearch(search) {
    this.isSearch = true;
    const searchValue = search.value.trim();
    if (searchValue !== '') {
      this.employeeService.search(searchValue).subscribe(data => {
        this.employees = data;
      });
    } else {
      this.ngOnInit();
    }
  }

  deleteEmployee(id: number) {
    this.employeeService.getEmployeeById(id).subscribe(data => {
        this.employeeService.deleteEmployee(id).subscribe(deletedData => {
          this.ngOnInit();
        });
      }
    );
  }

  previous() {
    this.page--;
    this.ngOnInit();
  }

  next() {
    this.page++;
    this.ngOnInit();
  }

  selectEmployee(employee: IEmployee) {
  this.selectedEmployee = employee;
  }
}
