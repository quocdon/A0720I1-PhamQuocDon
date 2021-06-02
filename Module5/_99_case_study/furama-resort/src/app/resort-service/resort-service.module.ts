import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ResortServiceRoutingModule } from './resort-service-routing.module';
import { ResortServiceListComponent } from './resort-service-list/resort-service-list.component';
import { ResortServiceCreateComponent } from './resort-service-create/resort-service-create.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { ResortServiceEditComponent } from './resort-service-edit/resort-service-edit.component';
import { ResortServiceDetailComponent } from './resort-service-detail/resort-service-detail.component';
import {NgxPaginationModule} from 'ngx-pagination';


@NgModule({
  declarations: [ResortServiceListComponent, ResortServiceCreateComponent, ResortServiceEditComponent, ResortServiceDetailComponent],
  imports: [
    CommonModule,
    ResortServiceRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    NgxPaginationModule
  ]
})
export class ResortServiceModule { }
