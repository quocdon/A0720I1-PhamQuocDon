import { Component, OnInit, ViewEncapsulation } from '@angular/core';

@Component({
  selector: 'app-view-default',
  templateUrl: './view-default.component.html',
  styleUrls: ['./view-default.component.scss'],
  encapsulation: ViewEncapsulation.Emulated
})
export class ViewDefaultComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
