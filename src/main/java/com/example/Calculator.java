package main.java.com.example;

public class Calculator {
    
    public int calculate(int a, int b, String op) {
        switch(op) {
            case "add", "add-again":  // FIXED: Merged cases with comma
                return a + b;
            
            case "sub", "sub-again":  // FIXED: Merged cases with comma
                return a - b;
            
            case "mul":
                return a * b;
            
            case "div":
                if(b == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return a / b;
            
            case "mod":
                if(b == 0) {
                    throw new ArithmeticException("Modulo by zero");
                }
                return a % b;
            
            case "pow":
                return (int) Math.pow(a, b);
            
            default:
                throw new IllegalArgumentException("Invalid operation: " + op);
        }
    }
}