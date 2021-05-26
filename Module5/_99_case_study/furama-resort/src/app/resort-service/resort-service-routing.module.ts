import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ResortServiceListComponent} from './resort-service-list/resort-service-list.component';
import {ResortServiceCreateComponent} from './resort-service-create/resort-service-create.component';
import {ResortServiceEditComponent} from './resort-service-edit/resort-service-edit.component';
import {ResortServiceDetailComponent} from './resort-service-detail/resort-service-detail.component';


const routes: Routes = [
  {path: '', component: ResortServiceListComponent},
  {path: 'create', component: ResortServiceCreateComponent},
  {path: 'view/:id', component: ResortServiceDetailComponent},
  {path: 'edit/:id', component: ResortServiceEditComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ResortServiceRoutingModule { }
