import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-rating-input',
  templateUrl: './rating-input.component.html',
  styleUrls: ['./rating-input.component.scss']
})
export class RatingInputComponent implements OnInit {
  max = 10;
  ratingValue = 5;
  showRatingValue = true;

  constructor() { }

  ngOnInit(): void {
  }

  onRateChange(rate: number) {
    this.ratingValue = rate;
  }

  setValue(maxInput: any, ratingValueInput: any) {
    this.max = maxInput.value;
    this.ratingValue = ratingValueInput.value;
  }
}
