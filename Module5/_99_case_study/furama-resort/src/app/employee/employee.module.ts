import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EmployeeRoutingModule } from './employee-routing.module';
import { EmployeeCreateComponent } from './employee-create/employee-create.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { EmployeeDetailComponent } from './employee-detail/employee-detail.component';
import { EmployeeEditComponent } from './employee-edit/employee-edit.component';
import {NgxPaginationModule} from 'ngx-pagination';


@NgModule({
  declarations: [EmployeeCreateComponent, EmployeeListComponent, EmployeeDetailComponent, EmployeeEditComponent],
  imports: [
    CommonModule,
    EmployeeRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    NgxPaginationModule
  ]
})
export class EmployeeModule { }
