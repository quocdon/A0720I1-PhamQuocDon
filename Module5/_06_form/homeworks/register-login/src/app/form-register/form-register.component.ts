import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';
import {differenceInYears} from 'date-fns';
import {compareSegments} from '@angular/compiler-cli/ngcc/src/sourcemaps/segment_marker';
import {UserServiceService} from '../services/user-service.service';
import {IUser} from '../model/IUser';
import {Router} from '@angular/router';

@Component({
  selector: 'app-form-register',
  templateUrl: './form-register.component.html',
  styleUrls: ['./form-register.component.scss']
})
export class FormRegisterComponent implements OnInit {
  registerForm: FormGroup;
  newUser: IUser;
  validationMessage = {
    'email': [
      {type: 'required', message: 'Email không để trống'},
      {type: 'pattern', message: 'Email đúng định dạng abc@xyz.com'}
    ],
    'password': [
      {type: 'required', message: 'Mật khẩu không để trống'},
      {type: 'minlength', message: 'Mật khẩu tối thiểu 6 ký tự'},
    ],
    'confirmPassword': [
      {type: 'required', message: 'Mật khẩu không để trống'},
      {type: 'minlength', message: 'Mật khẩu tối thiểu 6 ký tự'},
      {type: 'match', message: 'Mật khẩu chưa trùng khớp'}
    ],
    'country': [
      {type: 'required', message: 'Ngày sinh không để trống'},
    ],
    'birthday': [
      {type: 'required', message: 'Ngày sinh không để trống'},
      {type: 'pattern', message: 'Ngày sinh không đúng định dạng dd/MM/yyyy'},
      {type: 'age', message: 'Chưa đủ 18 tuổi'}
    ],
    'gender': [
      {type: 'required', message: 'Giới tính không để trống'},
      {type: 'pattern', message: 'Giới tính nam hoặc nữ'}
    ],
    'phone': [
      {type: 'required', message: 'Điện thoại không để trống'},
      {type: 'pattern', message: 'Điện thoại không đúng định dạng +84xxxxxxxxx'}
    ]
  };
  countries = ['Việt Nam', 'Hoa Kỳ', 'Anh', 'Pháp', 'Hàn Quốc', 'Nhật Bản'];

  constructor(private userService: UserServiceService, private router: Router) {
  }


  ngOnInit(): void {
    this.registerForm = new FormGroup({
      email: new FormControl('', Validators.compose([
        Validators.required,
        Validators.pattern(/^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/)
      ])),
      passwordGroup: new FormGroup({
        password: new FormControl('', Validators.compose([
          Validators.required,
          Validators.minLength(6)])),
        confirmPassword: new FormControl('', Validators.compose([
          Validators.required,
          Validators.minLength(6),
          validatePassword
        ]))
      }, {validators: validatePassword}),
      birthday: new FormControl('', Validators.compose([
        Validators.required,
        Validators.pattern(/^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$/),
        validateAge
      ])),
      country: new FormControl('', Validators.compose([
        Validators.required,
      ])),
      gender: new FormControl('', Validators.compose([
        Validators.required,
        Validators.pattern(/^Nam|Nữ$/)
      ])),
      phone: new FormControl('', Validators.compose([
        Validators.required,
        Validators.pattern(/^\+84\d{9,10}$/)
      ]))
    });
  }

  onSubmit() {
    if (this.registerForm.valid) {
      this.newUser = {
        email: this.registerForm.value.email,
        password: this.registerForm.value.passwordGroup.password,
        birthday: this.registerForm.value.birthday,
        gender: this.registerForm.value.gender,
        country: this.registerForm.value.country,
        phone: this.registerForm.value.phone
      };
      this.userService.addNewUser(this.newUser);
      this.router.navigateByUrl('/list');
    }
  }
}

function validateAge(formControl: AbstractControl) {
  const date = new Date(formControl.value);
  console.log(date);
  const now = new Date();
  if (differenceInYears(now, date) < 18) {
    return {age: true};
  }
  return null;
}

function validatePassword(formControl: AbstractControl) {
  const pw = formControl.value;
  if (pw.password !== pw.confirmPassword) {
    return {match: true};
  }
  return null;
}
