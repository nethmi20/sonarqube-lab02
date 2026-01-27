package main.java.com.example;

public class App {

    public static void main(String[] args) {
    try {
        Calculator calc = new Calculator();
        System.out.println(calc.calculate(10, 5, "add"));
        
        UserService service = new UserService();
        service.findUser("admin");
        
    } catch (Exception e) {
        System.err.println("Error: " + e.getMessage());
        e.printStackTrace();
    }
}
}
