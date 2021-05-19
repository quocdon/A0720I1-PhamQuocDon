import { Component, OnInit, ViewEncapsulation } from '@angular/core';

@Component({
  selector: 'app-view-none',
  templateUrl: './view-none.component.html',
  styleUrls: ['./view-none.component.scss'],
  encapsulation: ViewEncapsulation.None
})
export class ViewNoneComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
