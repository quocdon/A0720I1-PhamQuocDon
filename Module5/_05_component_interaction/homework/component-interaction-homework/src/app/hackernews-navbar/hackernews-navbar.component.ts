import {Component, DoCheck, EventEmitter, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-hackernews-navbar',
  templateUrl: './hackernews-navbar.component.html',
  styleUrls: ['./hackernews-navbar.component.scss']
})
export class HackernewsNavbarComponent implements OnInit, DoCheck {
  show = '';
  @Output()
  showOnchange: EventEmitter<string> = new EventEmitter<string>();

  constructor() { }

  ngOnInit(): void {
  }
  select(show: string) {
    this.show = show;
  }

  ngDoCheck(): void {
    this.showOnchange.emit(this.show);
  }
}
