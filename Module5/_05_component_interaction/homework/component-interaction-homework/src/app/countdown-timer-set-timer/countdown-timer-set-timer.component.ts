import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-countdown-timer-set-timer',
  templateUrl: './countdown-timer-set-timer.component.html',
  styleUrls: ['./countdown-timer-set-timer.component.scss']
})
export class CountdownTimerSetTimerComponent implements OnInit {

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
