import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginServiceService } from '../login-service.service';

@Component({
  selector: 'app-login-step1',
  templateUrl: './login-step1.component.html',
  styleUrls: ['./login-step1.component.scss']
})
export class LoginStep1Component implements OnInit {
  username = new FormControl('');
  constructor(
    private router: Router,
    private loginSrv: LoginServiceService) { }

  ngOnInit() {
  }

  nextStep() {
    this.loginSrv.loginData.username = this.username.value;
    this.router.navigateByUrl('/login-step-2');
  }

}
