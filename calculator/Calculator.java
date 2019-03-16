package calculator;

import static java.lang.Double.*;

public class Calculator {
    private final Display display;
    public String operator = "+";
    private boolean lastButtonWasDigit = false;
    private double a;
    private double b;

    public Calculator(Display display){
        this.display = display;
    }

    public boolean isLastButtonWasDigit(){
        return lastButtonWasDigit;
    }

    public double getNumber(){
        return parseDouble(display.getDisplayNumber());
    }

    public void setNumber(double number){
        display.setDisplayNumber(String.valueOf(number));
    }
    void digit(String digit) {
        if(lastButtonWasDigit){
            display.setDisplayNumber(display.getDisplayNumber()+digit);
        }
        else{
            display.setDisplayNumber(digit);
        }
        lastButtonWasDigit=true;
    }

    public void clear() {
        setNumber(0);
        lastButtonWasDigit=false;
        a = parseDouble("0");
        b = parseDouble("0");
        operator = "+";
    }

    public void comma() {
        if(!display.getDisplayNumber().contains(".")){
            display.setDisplayNumber(display.getDisplayNumber()+".");
        }
        lastButtonWasDigit=true;
    }

    void sqrt() {
        double numberSqrt = Math.sqrt(getNumber());
        setNumber(numberSqrt);
    }

    public void percent() {
        a = getNumber();
        double numberPercent = a/100*b;
        setNumber(numberPercent);
    }

    public void operator(String operator){
        if(lastButtonWasDigit){
            b = getNumber();
            calc();
        }
        this.operator = operator;
    }

    private void calc() {
            switch (operator) {
                case "+":
                    setNumber(a + b);
                    break;
                case "-":
                    setNumber(a - b);
                    break;
                case "*":
                    setNumber(a * b);
                    break;
                case "/":
                    setNumber(a / b);
                    break;
                default:
                    break;
            }
            a = getNumber();
            lastButtonWasDigit = false;
        }

    public void enter() {
        if(lastButtonWasDigit){
            b = getNumber();
        }
        calc();
    }

    public void delete() {
        if(lastButtonWasDigit){
            display.setDisplayNumber(display.getDisplayNumber().substring(0, display.getDisplayNumber().length()-1));
            if(display.getDisplayNumber().length()==0){
                display.setDisplayNumber("0");
                lastButtonWasDigit=false;
            }
        }
    }
}



