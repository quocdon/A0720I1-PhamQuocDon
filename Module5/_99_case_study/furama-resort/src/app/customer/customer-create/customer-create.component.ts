import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';
import {ICustomerType} from '../models/customer-type';
import {CustomerTypeService} from '../customer-type.service';
import {CustomerService} from '../customer.service';
import {CustomerListComponent} from '../customer-list/customer-list.component';
import {ICustomer} from '../models/customer';
import {Router} from '@angular/router';
import {of} from 'rxjs';

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.scss']
})
export class CustomerCreateComponent implements OnInit {
  createCustomer: FormGroup;
  customerTypes: ICustomerType[];
  customers: ICustomer[] = [];
  validationMessage = {
    'cus_id': [
      {type: 'required', message: 'Mã khách hàng không để trống'},
      {type: 'pattern', message: 'Mã khách hàng không đúng định dạng KH-XXXX'},
      {type: 'exist', message: 'Mã khách hàng đã tồn tại'}
    ],
    'name': [
      {type: 'required', message: 'Tên khách hàng không để trống'}
    ],
    'birthday': [
      {type: 'required', message: 'Ngày sinh không để trống'},
      {type: 'pattern', message: 'Ngày sinh không đúng định dạng dd/MM/yyyy'},
    ],
    'gender': [
      {type: 'required', message: 'Ngày sinh không để trống'},
    ],
    'id_card': [
      {type: 'required', message: 'CMND không để trống'},
      {type: 'pattern', message: 'CMND gồm 9 hoặc 12 chữ số'}
    ],
    'phone': [
      {type: 'required', message: 'Số điện thoại không để trống'},
      {type: 'pattern', message: 'Số điện thoại không đúng định dạng'}
    ],
    'email': [
      {type: 'required', message: 'Email không để trống'},
      {type: 'email', message: 'Email không đúng định dạng'}
    ],
    'cus_type': [
      {type: 'required', message: 'Chưa chọn hạng khách hàng'},
    ],
    'address': [
      {type: 'required', message: 'Email không để trống'},
    ]
  };
  constructor(private customerTypeService: CustomerTypeService,
              private customerService: CustomerService,
              private router: Router) { }

  ngOnInit(): void {
    this.customerTypeService.getAll().subscribe(data => {
      this.customerTypes = data;
    });
    this.customerService.getAll().subscribe((data) => {
      this.customers = data;
    });
    this.createCustomer = new FormGroup({
      cus_id: new FormControl('', Validators.compose([
        Validators.required,
        Validators.pattern(/^KH-\d{4}$/),
        this.validateCustomerId
      ])),
      name: new FormControl('', Validators.compose([
        Validators.required
      ])),
      birthday: new FormControl('', Validators.compose([
        Validators.required,
        Validators.pattern(/^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$/)
      ])),
      gender: new FormControl('', Validators.required),
      id_card: new FormControl('', Validators.compose([
        Validators.required,
        Validators.pattern(/(^(\d{9})$)|(^(\d{12})$)/)
      ])),
      phone: new FormControl('', Validators.compose([
        Validators.required,
        Validators.pattern(/^09[0-1][0-9]{7}|\(84\)\+9[0-1][0-9]{7}$/)
      ])),
      email: new FormControl('', Validators.compose([
        Validators.required,
        Validators.email
      ])),
      cus_type: new FormControl('', Validators.required),
      address: new FormControl('', Validators.required)
      });
  }

  onSubmit() {
    if (this.createCustomer.valid){
      this.customerService.createCustomer(this.createCustomer.value).subscribe(data => {
        this.router.navigateByUrl('customer/view/' + data.id);
      });
    }
  }
  validateCustomerId = (formControl: AbstractControl): any => {
    const cusId = formControl.value;
    let result: any;
    this.customerService.checkExist(cusId).subscribe(data => {
      result = data;
      if (data.length > 0) {
        return of({exist: true});
      }
    });
    return null;
  }
  compareWith(val1, val2){
    return val1.id === val2.id;
  }
}
