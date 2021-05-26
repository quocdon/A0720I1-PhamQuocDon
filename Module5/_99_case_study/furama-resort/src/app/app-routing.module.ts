import { NgModule } from '@angular/core';
import {Routes, RouterModule, PreloadAllModules} from '@angular/router';
import {AppComponent} from './app.component';
import {HomePageComponent} from './home-page/home-page.component';


const routes: Routes = [
  {path: '', component: HomePageComponent},
  {path: 'customer', loadChildren: () => import('./customer/customer.module').then(mod => mod.CustomerModule)},
  {path: 'employee', loadChildren: () => import('./employee/employee.module').then(mod => mod.EmployeeModule)},
  {path: 'service', loadChildren: () => import('./resort-service/resort-service.module').then(mod => mod.ResortServiceModule)},
  {path: 'contract', loadChildren: () => import('./contract/contract.module').then(mod => mod.ContractModule)}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {
    preloadingStrategy: PreloadAllModules
  })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
