import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pipe-demo',
  templateUrl: './pipe-demo.component.html',
  styleUrls: ['./pipe-demo.component.scss']
})
export class PipeDemoComponent implements OnInit {
  today = new Date();
  user = {
    name: 'bob mike'
  };

  price = 15000;
  symbol = 'VND';
  constructor() { }

  ngOnInit() {
  }

}
