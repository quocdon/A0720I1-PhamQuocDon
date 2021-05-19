import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../auth.service';

@Component({
  selector: 'app-content-child',
  templateUrl: './content-child.component.html',
  styleUrls: ['./content-child.component.scss']
})
export class ContentChildComponent implements OnInit {

  constructor(public authService: AuthService) { }

  ngOnInit() {
  }

}
