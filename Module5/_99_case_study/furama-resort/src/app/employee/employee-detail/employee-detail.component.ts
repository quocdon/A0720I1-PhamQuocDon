import { Component, OnInit } from '@angular/core';
import {IEmployee} from '../models/IEmployee';
import {EmployeeService} from '../service/employee.service';
import {ActivatedRoute} from '@angular/router';
import {ICustomer} from '../../customer/models/customer';

@Component({
  selector: 'app-employee-detail',
  templateUrl: './employee-detail.component.html',
  styleUrls: ['./employee-detail.component.scss']
})
export class EmployeeDetailComponent implements OnInit {
  employee: IEmployee;
  employeeId: string;
  constructor(
    private employeeService: EmployeeService,
    private activatedRoute: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(paramMap  => {
      this.employeeId = paramMap.get('id');
      this.employeeService.getEmployeeById(this.employeeId).subscribe((data) => {
        this.employee = data;
      });
    });
  }

}
