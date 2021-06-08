import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomePageComponent} from './components/home-page/home-page.component';
import {StudentListComponent} from './components/student-list/student-list.component';
import {StudentEditComponent} from './components/student-edit/student-edit.component';


const routes: Routes = [
  {path: '', component: HomePageComponent},
  {path: 'student', component: StudentListComponent},
  {path: 'student/edit/:id', component: StudentEditComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
