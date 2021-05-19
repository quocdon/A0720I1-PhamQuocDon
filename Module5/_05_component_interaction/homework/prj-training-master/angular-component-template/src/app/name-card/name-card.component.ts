import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-name-card',
  templateUrl: './name-card.component.html',
  styleUrls: ['./name-card.component.scss']
})
export class NameCardComponent implements OnInit {
  @Input() cardName: string;
  @Input() email: string;
  @Input() phone: string;

  constructor() { }

  ngOnInit() {
  }

}
