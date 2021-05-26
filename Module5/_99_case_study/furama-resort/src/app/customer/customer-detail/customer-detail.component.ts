import {Component, OnInit} from '@angular/core';
import {CustomerService} from '../customer.service';
import {ActivatedRoute} from '@angular/router';
import {ICustomer} from '../models/customer';

@Component({
  selector: 'app-customer-detail',
  templateUrl: './customer-detail.component.html',
  styleUrls: ['./customer-detail.component.scss']
})
export class CustomerDetailComponent implements OnInit {
  customer: ICustomer;
  customerId: string;

  constructor(
    private customerService: CustomerService,
    private activatedRoute: ActivatedRoute
  ) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(paramMap  => {
      this.customerId = paramMap.get('id');
      this.customerService.getCustomerById(this.customerId).subscribe((data: ICustomer) => {
        this.customer = data;
      });
    });
  }

}
