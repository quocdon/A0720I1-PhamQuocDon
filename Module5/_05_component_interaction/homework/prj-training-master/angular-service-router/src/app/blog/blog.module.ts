import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BlogRoutingModule } from './blog-routing.module';
import { BlogListComponent } from './blog-list/blog-list.component';

@NgModule({
  imports: [
    CommonModule,
    BlogRoutingModule
  ],
  declarations: [BlogListComponent]
})
export class BlogModule { }
