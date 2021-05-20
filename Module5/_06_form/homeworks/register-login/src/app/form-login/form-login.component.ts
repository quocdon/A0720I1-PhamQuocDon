import {Component, DoCheck, OnChanges, OnDestroy, OnInit, SimpleChanges} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {UserServiceService} from '../services/user-service.service';

@Component({
  selector: 'app-form-login',
  templateUrl: './form-login.component.html',
  styleUrls: ['./form-login.component.scss']
})
export class FormLoginComponent implements OnInit, OnDestroy {
  loginForm: FormGroup;
  message: string;

  validationMessage = {
    'email': [
      {type: 'required', message: 'Email không để trống'},
      {type: 'email', message: 'Email đúng định dạng abc@xyz.com'}
    ],
    'password': [
      {type: 'required', message: 'Mật khẩu không để trống'},
      {type: 'minlength', message: 'Mật khẩu tối thiểu 6 ký tự'},
    ],
  };

  constructor(private fb: FormBuilder, private userService: UserServiceService) {
  }

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    });
  }
  onSubmit(){
    if (this.loginForm.valid){
      if (this.userService.login(this.loginForm.value.email, this.loginForm.value.password)){
        this.message = 'Đăng nhập thành công';
      } else {
        this.message = 'Tài khoản, mật khẩu không chính xác';
      }
    }
  }

  ngOnDestroy(): void {
    this.message = '';
  }
}


