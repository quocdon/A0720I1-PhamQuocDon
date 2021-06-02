import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerTypeService} from '../customer-type.service';
import {CustomerService} from '../customer.service';
import {ActivatedRoute, Router} from '@angular/router';
import {ICustomerType} from '../models/customer-type';
import {ICustomer} from '../models/customer';
import * as moment from 'moment';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.scss']
})
export class CustomerEditComponent implements OnInit {
  customerForm: FormGroup;
  customerTypes: ICustomerType[];
  customers: ICustomer[] = [];
  customer: ICustomer;
  id: string;
  cusId: string;
  validationMessage = {
    'name': [
      {type: 'required', message: 'Tên khách hàng không để trống'}
    ],
    'birthday': [
      {type: 'required', message: 'Ngày sinh không để trống'},
      {type: 'pattern', message: 'Ngày sinh không đúng định dạng dd/MM/yyyy'},
      {type: 'invalid', message: 'Ngày không hợp lệ'}
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
              private router: Router,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.customerTypeService.getAll().subscribe(data => {
      this.customerTypes = data;
    });
    this.customerService.getAllCustomers().subscribe((data) => {
      this.customers = data;
    });
    this.initForm();
    this.activatedRoute.paramMap.subscribe(paramMap => {
      this.id = paramMap.get('id');
    });
    this.customerService.getCustomerById(this.id).subscribe(data => {
      this.customerForm.patchValue(data);
    });
  }

  initForm() {
    this.customerForm = new FormGroup({
      id: new FormControl(),
      cus_id: new FormControl(),
      name: new FormControl('', Validators.compose([
        Validators.required
      ])),
      birthday: new FormControl('', Validators.compose([
        Validators.required,
        Validators.pattern(/^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$/),
        validateDate
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
    console.log(this.customerForm.value);
    if (this.customerForm.valid) {
      this.customerService.editCustomer(this.id, this.customerForm.value).subscribe(data => {
        this.router.navigateByUrl('customer/view/' + data.id);
      });
    }
  }

  compareWith(val1, val2) {
    return val1.id === val2.id;
  }
}
function validateDate(formControl: AbstractControl) {
  const inputDate = formControl.value;
  if (moment(inputDate, 'DD/MM/YYYY').isValid()) {
    return null;
  }
  return {invalid: true};
}
