import { Component, OnInit } from '@angular/core';
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
  limit = 5;
  nextPage: ICustomer[] = [];
  isSearch = false;
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
              private router: Router) { }

  ngOnInit(): void {
    this.isSearch = false;
    this.customerService.getCustomerPagination(this.page, this.limit).subscribe(data => {
      this.customers = data;
    });
    this.customerService.getCustomerPagination(this.page + 1, this.limit).subscribe(data => {
      this.nextPage = data;
    });
  }

  doSearch(search) {
    this.isSearch = true;
    const searchValue = search.value.trim();
    if (searchValue !== ''){
      this.customerService.search(searchValue).subscribe(data => {
        this.customers = data;
      });
    } else {
      this.ngOnInit();
    }
  }

  deleteCustomer(id) {
    this.customerService.getCustomerById(id).subscribe(data => {
        this.customerService.deleteCustomer(id).subscribe(deletedData => {
          this.ngOnInit();
        });
    });
  }

  previous() {
    this.page--;
    this.ngOnInit();
  }

  next() {
    this.page++;
    this.ngOnInit();
  }

  selectCustomer(customer: ICustomer) {
    this.selectedCustomer = customer;
  }
}
