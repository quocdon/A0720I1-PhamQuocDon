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

  onChangeNumber1(value){
    this.number1 = Number(value);
  }
  onChangeNumber2(value){
    this.number2 = Number(value);
  }
  onChangeOperator(value){
    this.operator = value;
  }
  calculate(){
    switch (this.operator) {
      case '+' :
        this.result = this.number1 + this.number2;
        break;
      case '-':
        this.result = this.number1 - this.number2;
        break;
      case '*':
        this.result = this.number1 * this.number2;
        break;
      case '/':
        this.result = this.number1 / this.number2;
        break;
    }
  }
}
