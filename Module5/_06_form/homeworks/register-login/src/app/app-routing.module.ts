import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {FormRegisterComponent} from './form-register/form-register.component';
import {FormLoginComponent} from './form-login/form-login.component';
import {UserListComponent} from './user-list/user-list.component';


const routes: Routes = [
  {path: 'register', component: FormRegisterComponent},
  {path: 'login', component: FormLoginComponent},
  {path: 'list', component: UserListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
