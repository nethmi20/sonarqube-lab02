package main.java.com.example;

public class Calculator {

    public int calculate(int a, int b, String op) {
        switch (op) {
            case "add":
                return a + b;
            case "sub":
                return a - b;
            case "mul":
                return a * b;
            case "div":
                return b != 0 ? a / b : 0;
            case "mod":
                return a % b;
            case "pow":
                int result = 1;
                for (int i = 0; i < b; i++) {
                    result *= a;
                }
                return result;
            default:
                return 0;
        }
    }
}
