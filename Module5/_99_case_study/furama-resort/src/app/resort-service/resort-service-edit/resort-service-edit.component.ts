import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ResortServiceService} from '../services/resort-service.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-resort-service-edit',
  templateUrl: './resort-service-edit.component.html',
  styleUrls: ['./resort-service-edit.component.scss']
})
export class ResortServiceEditComponent implements OnInit {
  serviceForm: FormGroup;
  rentTypes: string[];
  id: string;

  validationMessage = {
    'service_id': [
      {type: 'required', message: 'Mã dịch vụ không để trống'},
      {type: 'pattern', message: 'Mã dịch vụ không đúng định dạng DV-XXXX'}
    ],
    'name': [
      {type: 'required', message: 'Tên dịch vụ không để trống'}
    ],
    'area': [
      {type: 'required', message: 'Diện tích không để trống'},
      {type: 'min', message: 'Diên tích tối thiểu 15m2'},
      {type: 'pattern', message: 'Số khách phải là số nguyên dương'}
    ],
    'price': [
      {type: 'required', message: 'Giá tiền không để trống'},
      {type: 'pattern', message: 'Giá tiền phải là số nguyên dương'}
    ],
    'max_people': [
      {type: 'required', message: 'Số khách tối đa không để trống'},
      {type: 'pattern', message: 'Số khách phải là số nguyên dương'}
    ],
    'rent_type': [
      {type: 'required', message: 'Chưa chọn kiểu thuê'}
    ]
  };

  constructor(private resortServiceService: ResortServiceService,
              private router: Router,
              private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.rentTypes = this.resortServiceService.getAllRentType();
    this.initForm();
    this.activatedRoute.paramMap.subscribe(paramMap => {
      this.id = paramMap.get('id');
    });
    this.resortServiceService.getServiceById(this.id).subscribe(data => {
      this.serviceForm.patchValue(data);
    });
  }
  initForm() {
    this.serviceForm = new FormGroup({
      id: new FormControl(),
      service_id: new FormControl('', Validators.compose([
        Validators.required,
        Validators.pattern(/^DV-\d{4}$/)
      ])),
      name: new FormControl('', Validators.required),
      area: new FormControl('', Validators.compose([
        Validators.required,
        Validators.min(15),
        Validators.pattern(/^[1-9]\d*$/)
      ])),
      price: new FormControl('', Validators.compose([
        Validators.required,
        Validators.pattern(/^[1-9]\d*$/)
      ])),
      max_people: new FormControl('', Validators.compose([
        Validators.required,
        Validators.pattern(/^[1-9]\d*$/)
      ])),
      rent_type: new FormControl('', Validators.required),
    });
  }

  onSubmit() {
    if (this.serviceForm.valid) {
      this.resortServiceService.editService(this.id, this.serviceForm.value).subscribe(data => {
        alert('Cập nhật thành công dịch vụ ' + data.name);
        this.router.navigateByUrl('service/view/' + data.id);
      });
    }
  }

}
