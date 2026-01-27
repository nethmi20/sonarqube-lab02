package main.java.com.example;

import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        try {
            Calculator calc = new Calculator();
            logger.log(Level.INFO, "Result: {0}", calc.calculate(10, 5, "add"));
            
            UserService service = new UserService();
            service.findUser("admin");
            
        } catch (DatabaseException e) {
            // FIXED: Using logger instead of System.err
            logger.log(Level.SEVERE, "Database error occurred", e);
        } catch (Exception e) {
            // FIXED: Using logger instead of System.err
            logger.log(Level.SEVERE, "Error occurred", e);
        }
    }
}