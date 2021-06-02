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
  page: number = 1;
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
  searchValue = '';

  constructor(private employeeService: EmployeeService) {
  }

  ngOnInit(): void {
    this.searchValue = '';
    this.employeeService.getAllEmployees().subscribe(
      (data) => this.employees = data
    );
  }

  doSearch() {
    this.page = 1;
    this.searchValue = this.searchValue.trim();
    this.employeeService.search(this.searchValue).subscribe(
      data => {
        this.employees = data;       }
      );
  }

  deleteEmployee(id: number) {
    this.employeeService.getEmployeeById(id).subscribe(data => {
        this.employeeService.deleteEmployee(id).subscribe(deletedData => {
          this.ngOnInit();
        });
      }
    );
  }

  selectEmployee(employee: IEmployee) {
    this.selectedEmployee = employee;
  }
}
