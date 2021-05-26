import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {EmployeeListComponent} from './employee-list/employee-list.component';
import {EmployeeCreateComponent} from './employee-create/employee-create.component';
import {EmployeeDetailComponent} from './employee-detail/employee-detail.component';
import {EmployeeEditComponent} from './employee-edit/employee-edit.component';


const routes: Routes = [
  {path: '', component: EmployeeListComponent},
  {path: 'create', component: EmployeeCreateComponent},
  {path: 'view/:id', component: EmployeeDetailComponent},
  {path: 'edit/:id', component: EmployeeEditComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EmployeeRoutingModule { }
