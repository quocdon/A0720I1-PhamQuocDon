import { Component, OnInit } from '@angular/core';
import {IEmployee} from '../models/IEmployee';
import {EmployeeService} from '../service/employee.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.scss']
})
export class EmployeeListComponent implements OnInit {
  employees: IEmployee[];

  constructor(private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.employeeService.getAllEmployees().subscribe(data => {
      this.employees = data;
    });
  }

  doSearch(search) {
    const searchValue = search.value;
    this.employeeService.search(searchValue).subscribe(data => {
      this.employees = data;
    });
  }

  deleteEmployee(id: number) {
    this.employeeService.getEmployeeById(id).subscribe(data => {
      if (confirm('Bạn muốn xóa nhân viên ' + data.name + ' không?')){
        this.employeeService.deleteEmployee(id).subscribe(deletedData => {
          alert('Xóa thành công nhân viên ' + data.name);
          this.ngOnInit();
        });
      }
    });
  }
}
