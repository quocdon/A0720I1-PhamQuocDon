import { Component, OnInit, ViewEncapsulation } from '@angular/core';

@Component({
  selector: 'app-view-shadow-dom',
  templateUrl: './view-shadow-dom.component.html',
  styleUrls: ['./view-shadow-dom.component.scss'],
  encapsulation: ViewEncapsulation.ShadowDom
})
export class ViewShadowDomComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
