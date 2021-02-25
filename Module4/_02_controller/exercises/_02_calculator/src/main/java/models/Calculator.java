package models;

public class Calculator {
    private double number1;
    private double number2;
    private String operator;

    public Calculator() {
        this.number1 = 0;
        this.number2 = 0;
        this.operator = "addition";
    }

    public Calculator(double number1, double number2, String operator) {
        this.number1 = number1;
        this.number2 = number2;
        this.operator = operator;
    }

    public double getNumber1() {
        return number1;
    }

    public void setNumber1(double number1) {
        this.number1 = number1;
    }

    public double getNumber2() {
        return number2;
    }

    public void setNumber2(double number2) {
        this.number2 = number2;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double calculate() {
        if (operator.equals("Addition")) {
            return number1 + number2;
        } else if (operator.equals("Subtraction")) {
            return number1 - number2;
        } else if (operator.equals("Multiple")) {
            return number1 * number2;
        } else {
            return number1 / number2;
        }
    }
}
