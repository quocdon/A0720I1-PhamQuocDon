import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';
import {ICustomer} from '../../customer/models/customer';
import {CustomerService} from '../../customer/customer.service';
import {EmployeeService} from '../../employee/service/employee.service';
import {ResortServiceService} from '../../resort-service/services/resort-service.service';
import {AttachServiceService} from '../services/attach-service.service';
import {IResortService} from '../../resort-service/models/resort-service';
import {IEmployee} from '../../employee/models/IEmployee';
import * as moment from 'moment';
import {IAttachService} from '../models/attach-service';
import {IContractDetail} from '../models/contract-detail';
import {IContract} from '../models/contract';
import {ContractService} from '../services/contract.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-contract-create',
  templateUrl: './contract-create.component.html',
  styleUrls: ['./contract-create.component.scss']
})
export class ContractCreateComponent implements OnInit {
  contractForm: FormGroup;
  validationMessage = {
    'customer': [
      {type: 'required', message: 'Chưa chọn khách hàng'},
    ],
    'service': [
      {type: 'required', message: 'Chưa chọn dịch vụ'},
    ],
    'employee': [
      {type: 'required', message: 'Chưa chọn nhân viên'},
    ],
    'start_date': [
      {type: 'required', message: 'Ngày không để trống'},
      {type: 'pattern', message: 'Ngày không đúng định dạng dd/MM/yyyy'},
    ],
    'end_date': [
      {type: 'required', message: 'Ngày không để trống'},
      {type: 'pattern', message: 'Ngày không đúng định dạng dd/MM/yyyy'},
    ],
    'stay_period': [
      {type: 'period', message: 'Ngày kết thúc phải sau ngày bắt đầu'}
    ],
    'detail_group': [
      {type: 'invalid', message: 'Số lượng dịch vụ phải là số nguyên dương'}
    ]
  };
  customers: ICustomer[];
  services: IResortService[];
  employees: IEmployee[];
  contract: IContract;
  attachServices: IAttachService[];
  contractDetails: IContractDetail[] = [];

  constructor(
    private customerService: CustomerService,
    private employeeService: EmployeeService,
    private resortServiceService: ResortServiceService,
    private attachServiceService: AttachServiceService,
    private contractService: ContractService,
    private router: Router
  ) {
  }

  ngOnInit(): void {
    this.getListOfInformation();
    this.initForm();
  }

  initForm() {
    this.contractForm = new FormGroup({
      customer: new FormControl('', Validators.required),
      service: new FormControl('', Validators.required),
      employee: new FormControl('', Validators.required),
      stay_period: new FormGroup({
        start_date: new FormControl('', Validators.compose([
          Validators.required,
          Validators.pattern(/^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$/)
        ])),
        end_date: new FormControl('', Validators.compose([
          Validators.required,
          Validators.pattern(/^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$/),
        ]))
      }, {validators: checkPeriod})
    });
  }

  getListOfInformation() {
    this.customerService.getAll().subscribe(data => {
      this.customers = data;
    });
    this.resortServiceService.getAllServices().subscribe(data => {
      this.services = data;
    });
    this.employeeService.getAllEmployees().subscribe(data => {
      this.employees = data;
    });
    this.attachServiceService.getAllAttachServices().subscribe(data => {
      this.attachServices = data;
    });
  }

  onSubmit() {
    this.contract = this.contractForm.value;
    this.contract.contract_detail = this.contractDetails;
    this.calculateAmount();
    this.contractService.createContract(this.contract).subscribe(data => {
      alert('Tạo mới thành công hợp đồng\r\n - Khách hàng: ' + data.customer.name + '\r\n - Dịch vụ: ' + data.service.name);
    });
    this.router.navigateByUrl('/contract');
  }

  initContractDetail(attachService, qty) {
    const index = this.contractDetails.findIndex(contractDetail => contractDetail.attach_service.id === attachService.id);
    if (index !== -1) {
      if (qty.value !== '0') {
        this.contractDetails[index].quantity = +qty.value;
      } else {
        this.contractDetails.splice(index, 1);
      }
    } else {
      if (qty.value !== '0') {
        this.contractDetails.push({
          attach_service: attachService,
          quantity: +qty.value
        });
      }
    }
  }

  calculateAmount() {
    let attachServiceAmount = 0;
    const startDate = moment(this.contract.stay_period.start_date, 'DD/MM/YYYY').toDate();
    const endDate = moment(this.contract.stay_period.end_date, 'DD/MM/YYYY').toDate();
    for (const detail of this.contract.contract_detail) {
      attachServiceAmount += detail.attach_service.price * detail.quantity;
    }
    const serviceAmount = this.contract.service.price * ((endDate.getTime() - startDate.getTime()) / (1000 * 24 * 3600));
    this.contract.amount = attachServiceAmount + serviceAmount;
  }
}

function checkPeriod(formControl: AbstractControl) {
  const period = formControl.value;
  const startDate = moment(period.start_date, 'DD/MM/YYYY').toDate();
  const endDate = moment(period.end_date, 'DD/MM/YYYY').toDate();
  if (startDate < endDate) {
    return null;
  } else {
    return {period: true};
  }
}
