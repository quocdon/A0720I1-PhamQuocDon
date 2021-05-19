import {Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';
import {IRatingUnit} from '../rating-model/IRatingUnit';

@Component({
  selector: 'app-rating-bar',
  templateUrl: './rating-bar.component.html',
  styleUrls: ['./rating-bar.component.scss']
})
export class RatingBarComponent implements OnInit, OnChanges {
  @Input() max: number;
  @Input() ratingValue: number;
  @Input() showRatingValue: boolean;
  @Output() rateChange: EventEmitter<number> = new EventEmitter<number>();
  ratingUnits: Array<IRatingUnit> = [];

  constructor() {
  }

  ngOnInit(): void {
    this.calculate(this.max, this.ratingValue);
  }

  ngOnChanges(changes: SimpleChanges): void {
    if ('max' in changes) {
      let max = changes.max.currentValue;
      max = typeof max === ('undefined' || '') ? 10 : max;
      const vMax = Number(max);
      max = Number.isNaN(vMax) ? 10 : vMax;
      this.max = max;
      this.calculate(this.max, this.ratingValue);
    }

    if ('ratingValue' in changes) {
      let ratingValue = changes.ratingValue.currentValue;
      ratingValue = typeof ratingValue === ('undefined' || '') ? 5 : ratingValue;
      const vRatingValue = Number(ratingValue);
      ratingValue = Number.isNaN(vRatingValue) ? 5 : vRatingValue;
      this.ratingValue = ratingValue;
      this.calculate(this.max, this.ratingValue);
    }
    if (this.ratingValue > this.max) {
      this.ratingValue = this.max;
      this.calculate(this.max, this.ratingValue);
    }
  }

  private calculate(max: any, ratingValue: number) {
    this.ratingUnits = [];
    for (let rate = 1; rate <= max; rate++) {
      this.ratingUnits.push(
        {
          value: rate,
          active: rate <= ratingValue
        }
      );
    }
  }

  select(index) {
    this.ratingValue = index + 1;
    this.ratingUnits.forEach((item, idx) =>
      item.active = idx < this.ratingValue);
    this.rateChange.emit(this.ratingValue);
  }

  enter(index) {
    this.ratingUnits.forEach((item, idx) =>
      item.active = idx <= index);
  }

  reset() {
    this.ratingUnits.forEach((item, idx) =>
      item.active = idx < this.ratingValue);
  }
}
