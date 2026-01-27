package main.java.com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserService {

    // FIXED: Use environment variable or config file instead
    private String getPassword() {
        return System.getenv("DB_PASSWORD");
    }

    // FIXED: Using PreparedStatement to prevent SQL injection
    public void findUser(String username) throws Exception {
        String url = "jdbc:mysql://localhost/db";
        String password = getPassword();
        
        try (Connection conn = DriverManager.getConnection(url, "root", password);
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM users WHERE name = ?")) {
            
            pstmt.setString(1, username);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    System.out.println(rs.getString("name"));
                }
            }
        }
    }

    // FIXED: Using PreparedStatement to prevent SQL injection
    public void deleteUser(String username) throws Exception {
        String url = "jdbc:mysql://localhost/db";
        String password = getPassword();
        
        try (Connection conn = DriverManager.getConnection(url, "root", password);
             PreparedStatement pstmt = conn.prepareStatement("DELETE FROM users WHERE name = ?")) {
            
            pstmt.setString(1, username);
            pstmt.execute();
        }
    }    
}