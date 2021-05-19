import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  user: any;
  constructor() { }

  isAuthenticated(): boolean {
    return !!this.user;
  }
  login() {
    this.user = {
      name: 'bob',
      token: 'token'
    };
  }
  logout() {
    this.user = null;
  }
}
