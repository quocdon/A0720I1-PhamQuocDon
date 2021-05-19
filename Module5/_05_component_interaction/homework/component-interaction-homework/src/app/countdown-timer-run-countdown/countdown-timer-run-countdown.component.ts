import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-countdown-timer-run-countdown',
  templateUrl: './countdown-timer-run-countdown.component.html',
  styleUrls: ['./countdown-timer-run-countdown.component.scss']
})
export class CountdownTimerRunCountdownComponent implements OnInit {

  @Input() remainingTime: number;
  isStop = false;
  message = '';

  constructor() {
  }

  ngOnInit(): void {
  }

  start() {
    this.isStop = false;
    this.message = 'The timer is counting down';
    const interval = setInterval(() => {
      if ((this.remainingTime <= 0) || (this.isStop)) {
        clearInterval(interval);
        if (this.remainingTime <= 0 && !this.isStop) {
          this.message = 'The timer stop';
        } else if (this.isStop) {
          this.message = 'The timer pause at ' + this.remainingTime + ' seconds remaining. Press Start to continue';
        }
      } else {
        this.remainingTime--;
      }
    }, 1000);
  }

  pause() {
    this.isStop = true;
  }

  clear() {
    this.remainingTime = 0;
    this.message = 'The timer clear. Please set countdown timer again';
  }

}
