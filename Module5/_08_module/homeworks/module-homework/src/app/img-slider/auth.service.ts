import {Injectable} from '@angular/core';

let defaultId = 1;

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  user: string = 'Default Id:' + defaultId++;

  constructor() {
  }
}
