package main.java.com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserService {

    private static final Logger logger = Logger.getLogger(UserService.class.getName());
    
    // FIXED: Use environment variable or config file instead
    private String getPassword() {
        return System.getenv("DB_PASSWORD");
    }

    // FIXED: Using PreparedStatement, specific columns, and custom exception
    public void findUser(String username) throws DatabaseException {
        String url = "jdbc:mysql://localhost/db";
        String password = getPassword();
        
        // FIXED: SELECT specific columns instead of *
        String query = "SELECT id, name, email FROM users WHERE name = ?";
        
        try (Connection conn = DriverManager.getConnection(url, "root", password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, username);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    // FIXED: Using logger instead of System.out
                    logger.log(Level.INFO, "User found: {0}", rs.getString("name"));
                }
            }
        } catch (SQLException e) {
            // FIXED: Throw custom exception instead of generic Exception
            throw new DatabaseException("Error finding user: " + username, e);
        }
    }

    // FIXED: Using PreparedStatement and custom exception
    public void deleteUser(String username) throws DatabaseException {
        String url = "jdbc:mysql://localhost/db";
        String password = getPassword();
        
        try (Connection conn = DriverManager.getConnection(url, "root", password);
             PreparedStatement pstmt = conn.prepareStatement("DELETE FROM users WHERE name = ?")) {
            
            pstmt.setString(1, username);
            pstmt.execute();
            
        } catch (SQLException e) {
            // FIXED: Throw custom exception instead of generic Exception
            throw new DatabaseException("Error deleting user: " + username, e);
        }
    }
}

// FIXED: Custom exception class
class DatabaseException extends Exception {
    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
    }
}