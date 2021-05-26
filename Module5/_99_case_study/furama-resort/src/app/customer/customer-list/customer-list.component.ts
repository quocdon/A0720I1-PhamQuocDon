import { Component, OnInit } from '@angular/core';
import {ICustomer} from '../models/customer';
import {CustomerService} from '../customer.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.scss']
})
export class CustomerListComponent implements OnInit {
  customers: ICustomer[];

  constructor(private customerService: CustomerService,
              private router: Router) { }

  ngOnInit(): void {
    this.customerService.getAll().subscribe(data => {
      this.customers = data;
    });
  }

  doSearch(search) {
    const searchValue = search.value;
    this.customerService.search(searchValue).subscribe(data => {
      this.customers = data;
    });
  }

  deleteCustomer(id) {
    this.customerService.getCustomerById(id).subscribe(data => {
      if (confirm('Bạn muốn xóa khách hàng ' + data.name + ' không?')){
        this.customerService.deleteCustomer(id).subscribe(deletedData => {
          alert('Xóa thành công khách hàng ' + data.name);
          this.ngOnInit();
        });
      }
    });
  }
}
