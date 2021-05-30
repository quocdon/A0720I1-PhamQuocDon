import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'angular-service-router';

  constructor(private router: Router) {}
  gotoTimelines() {
    this.router.navigate(['/timelines']);
  }
}
