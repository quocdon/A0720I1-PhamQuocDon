import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-content-projection',
  templateUrl: './content-projection.component.html',
  styleUrls: ['./content-projection.component.scss'],
  // providers: [AuthService]
  viewProviders: [AuthService]
})
export class ContentProjectionComponent implements OnInit {

  constructor(public authService: AuthService) { }

  ngOnInit() {
  }

}
