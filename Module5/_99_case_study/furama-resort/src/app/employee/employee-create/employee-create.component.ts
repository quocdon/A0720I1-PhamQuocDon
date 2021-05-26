import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {EmployeeService} from '../service/employee.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-employee-create',
  templateUrl: './employee-create.component.html',
  styleUrls: ['./employee-create.component.scss']
})
export class EmployeeCreateComponent implements OnInit {
  employeeForm: FormGroup;
  departments: string[];
  positions: string[];
  degrees: string[];
  validationMessage = {
    'em_id': [
      {type: 'required', message: 'Mã nhân viên không để trống'},
      {type: 'pattern', message: 'Mã nhân viên không đúng định dạng NV-XXXX'},
    ],
    'name': [
      {type: 'required', message: 'Tên nhân viên không để trống'}
    ],
    'birthday': [
      {type: 'required', message: 'Ngày sinh không để trống'},
      {type: 'pattern', message: 'Ngày sinh không đúng định dạng dd/MM/yyyy'},
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
              private router: Router) { }

  ngOnInit(): void {
    this.departments = this.employeeService.getAllDepartments();
    this.positions = this.employeeService.getAllPositions();
    this.degrees = this.employeeService.getAllDegrees();
    this.initForm();
  }

  initForm(){
    this.employeeForm = new FormGroup({
      em_id: new FormControl('', Validators.compose([
        Validators.required,
        Validators.pattern(/^NV-\d{4}$/)
      ])),
      name: new FormControl('', Validators.required),
      birthday: new FormControl('', Validators.compose([
        Validators.required,
        Validators.pattern(/^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$/)
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
      this.employeeService.createEmployee(this.employeeForm.value).subscribe(data => {
        alert('Tạo mới thành công nhân viên ' + data.name);
        this.router.navigateByUrl('employee/view/' + data.id);
      });
    }
  }
}
