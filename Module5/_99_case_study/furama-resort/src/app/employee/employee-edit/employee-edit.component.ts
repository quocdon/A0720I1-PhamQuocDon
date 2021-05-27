import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';
import {EmployeeService} from '../service/employee.service';
import {ActivatedRoute, Router} from '@angular/router';
import * as moment from 'moment';

@Component({
  selector: 'app-employee-edit',
  templateUrl: './employee-edit.component.html',
  styleUrls: ['./employee-edit.component.scss']
})
export class EmployeeEditComponent implements OnInit {
  employeeForm: FormGroup;
  departments: string[];
  positions: string[];
  degrees: string[];
  id: string;
  validationMessage = {
    'name': [
      {type: 'required', message: 'Tên nhân viên không để trống'}
    ],
    'birthday': [
      {type: 'required', message: 'Ngày sinh không để trống'},
      {type: 'pattern', message: 'Ngày sinh không đúng định dạng dd/MM/yyyy'},
      {type: 'invalid', message: 'Ngày không hợp lệ'}
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
    'position': [
      {type: 'required', message: 'Chưa chọn vị trí'},
    ],
    'department': [
      {type: 'required', message: 'Chưa chọn bộ phận'},
    ],
    'degree': [
      {type: 'required', message: 'Chưa chọn trình độ'},
    ]
  };

  constructor(private employeeService: EmployeeService,
              private router: Router,
              private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.departments = this.employeeService.getAllDepartments();
    this.positions = this.employeeService.getAllPositions();
    this.degrees = this.employeeService.getAllDegrees();
    this.initForm();
    this.activatedRoute.paramMap.subscribe(paramMap => {
      this.id = paramMap.get('id');
    });
    this.employeeService.getEmployeeById(this.id).subscribe(data => {
      this.employeeForm.patchValue(data);
    });
  }

  initForm(){
    this.employeeForm = new FormGroup({
      id: new FormControl(),
      em_id: new FormControl(),
      name: new FormControl('', Validators.required),
      birthday: new FormControl('', Validators.compose([
        Validators.required,
        Validators.pattern(/^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$/),
        validateDate
      ])),
      position: new FormControl('', Validators.required),
      department: new FormControl('', Validators.required),
      degree: new FormControl('', Validators.required),
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
      ]))
    });
  }

  onSubmit() {
    if (this.employeeForm.valid){
      this.employeeService.editEmployee(this.id, this.employeeForm.value).subscribe(data => {
        alert('Cập nhật thành công nhân viên ' + data.name);
        this.router.navigateByUrl('employee/view/' + data.id);
      });
    }
  }
}
function validateDate(formControl: AbstractControl) {
  const inputDate = formControl.value;
  if (moment(inputDate, 'DD/MM/YYYY').isValid()) {
    return null;
  }
  return {invalid: true};
}
