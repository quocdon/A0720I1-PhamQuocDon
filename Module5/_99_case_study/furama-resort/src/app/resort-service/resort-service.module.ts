import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ResortServiceRoutingModule } from './resort-service-routing.module';
import { ResortServiceListComponent } from './resort-service-list/resort-service-list.component';
import { ResortServiceCreateComponent } from './resort-service-create/resort-service-create.component';
import {ReactiveFormsModule} from '@angular/forms';
import { ResortServiceEditComponent } from './resort-service-edit/resort-service-edit.component';
import { ResortServiceDetailComponent } from './resort-service-detail/resort-service-detail.component';


@NgModule({
  declarations: [ResortServiceListComponent, ResortServiceCreateComponent, ResortServiceEditComponent, ResortServiceDetailComponent],
  imports: [
    CommonModule,
    ResortServiceRoutingModule,
    ReactiveFormsModule
  ]
})
export class ResortServiceModule { }
