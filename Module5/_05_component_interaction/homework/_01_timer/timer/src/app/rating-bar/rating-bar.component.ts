import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {IRatingUnit} from '../IRatingUnit';
import index from '@angular/cli/lib/cli';

@Component({
  selector: 'app-rating-bar',
  templateUrl: './rating-bar.component.html',
  styleUrls: ['./rating-bar.component.css']
})
export class RatingBarComponent implements OnInit, OnChanges {
  @Input() max: number;
  @Input() ratingValue: number;
  @Input() showRatingValue: true;
  ratingUnits: Array<IRatingUnit> = [];
  constructor() { }

  ngOnInit(): void {
    this.calculate(this.max, this.ratingValue)
  }

  ngOnChanges(changes: SimpleChanges): void {
    if ('max' in changes){
      let max = changes.max.currentValue;
      max = typeof max === 'undefined' ? 5 : max;
      this.max = max;
      this.calculate(max, this.ratingValue);
    }
  }

  private calculate(max: any, ratingValue: number) {
    for (let rate = 1; rate <= max; rate++){
      this.ratingUnits.push(
        {
          value: rate,
          active: rate <= ratingValue
        }
      );
    }
  }
}
