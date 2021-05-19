import {Component, OnChanges, OnInit, SimpleChanges} from '@angular/core';

@Component({
  selector: 'app-set-timer',
  templateUrl: './set-timer.component.html',
  styleUrls: ['./set-timer.component.css']
})
export class SetTimerComponent implements OnInit {
  remainingTime: number;
  constructor() { }

  ngOnInit(): void {
  }

  setRemainingTime(time: any) {
    time = time.value.trim();
    time = (typeof time === 'undefined') || time === '' ? 15 : time;
    const vTime = Number(time);
    time = Number.isNaN(vTime) ? 15 : time;
    this.remainingTime = time;
  }
}
