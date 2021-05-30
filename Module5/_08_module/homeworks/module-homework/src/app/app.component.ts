import { Component } from '@angular/core';
import {AuthService} from './img-slider/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'module-homework';
  constructor(public authService: AuthService) {
  }
}
