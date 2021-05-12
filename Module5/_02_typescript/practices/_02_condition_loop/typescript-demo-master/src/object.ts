import './scss/styles.scss';

interface IUser {
  name: string;
  age: number
}

let customer: IUser = {
  name: 'Bob',
  age: 50
};

console.log(customer);

/* customer = {
  name: 'Anna'
}; */
/*
* Error: Type '{ name: string; }' is not assignable to type 'IUser'.
* Property 'age' is missing in type '{ name: string; }'.
*/

class Shape {
  public x: number;
  public y: number;
  constructor(x: number, y: number) {
    this.x = x;
    this.y = y;
  }
  toString(): string {
    return `(x: ${this.x}, y: ${this.y})`;
  }
}

interface IArea {
  area(): number;
}

class Rect extends Shape implements IArea {
  constructor(x: number, y: number, public width: number, public height: number) {
    super(x, y);
  }
  area(): number {
    return this.width * this.height;
  }
}

const rect = new Rect(5, 5, 10, 20);
console.log(rect.toString());
console.log(rect.area());

