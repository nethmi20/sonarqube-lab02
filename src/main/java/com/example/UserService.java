package main.java.com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserService {

    private String password = "admin123"; // kept for lab simplicity

    // SAFE: Look up user using PreparedStatement to prevent SQL Injection
    public ResultSet findUser(String username) throws Exception {
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost/db", "root", password
        );
        String query = "SELECT * FROM users WHERE name = ?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, username);
        return pst.executeQuery();
    }

    // SAFE: Delete user using PreparedStatement to prevent SQL Injection
    public void deleteUser(String username) throws Exception {
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost/db", "root", password
        );
        String query = "DELETE FROM users WHERE name = ?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, username);
        pst.executeUpdate();
    }
}
