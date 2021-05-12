import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
  number1 = 0;
  number2 = 0;
  operator = '+';
  result = 0;

  constructor() { }

  ngOnInit(): void {
  }

  calculate(){
    this.result = eval(this.number1 + this.operator + this.number2);
  }
}
