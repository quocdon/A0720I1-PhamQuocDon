import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { LoginServiceService } from '../login-service.service';

@Component({
  selector: 'app-login-step2',
  templateUrl: './login-step2.component.html',
  styleUrls: ['./login-step2.component.scss']
})
export class LoginStep2Component implements OnInit {
  username: string;
  password = new FormControl();
  constructor(private loginSrv: LoginServiceService) {}

  ngOnInit() {
    this.username = this.loginSrv.loginData.username;
  }

  login() {
    // do login
    console.log({
      username: this.username,
      password: this.password.value
    });
  }
}
