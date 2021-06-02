import {Component, OnInit} from '@angular/core';
import {ICustomer} from '../models/customer';
import {CustomerService} from '../customer.service';
import {Router} from '@angular/router';
import {ICustomerType} from '../models/customer-type';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.scss']
})
export class CustomerListComponent implements OnInit {
  customers: ICustomer[];
  page = 1;
  searchValue = '';
  selectedCustomer: ICustomer = {
    id: 0,
    cus_id: '',
    name: '',
    birthday: '',
    gender: '',
    id_card: '',
    phone: '',
    email: '',
    cus_type: null,
    address: ''
  };

  constructor(private customerService: CustomerService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.searchValue = '';
    this.customerService.getAllCustomers().subscribe(
      (data) => this.customers = data
    );
  }

  doSearch() {
    this.page = 1;
    this.searchValue = this.searchValue.trim();
    this.customerService.search(this.searchValue).subscribe(
      (data) => this.customers = data
    );
  }

  deleteCustomer(id) {
    this.customerService.deleteCustomer(id).subscribe(data => {
      this.ngOnInit();
    });
  }

  selectCustomer(customer: ICustomer) {
    this.selectedCustomer = customer;
  }
}
