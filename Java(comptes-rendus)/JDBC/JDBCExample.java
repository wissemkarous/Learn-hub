package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCExample {

    // Database connection information
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/your_database";
    static final String USER = "your_username";
    static final String PASS = "your_password";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Establish database connection
            System.out.println("Connecting to the database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Execute a SQL query
            String sql = "SELECT id, last_name, first_name FROM user";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            // Iterate through the results
            while (rs.next()) {
                int id = rs.getInt("id");
                String lastName = rs.getString("last_name");
                String firstName = rs.getString("first_name");

                // Display the results
                System.out.println("ID: " + id + ", Last Name: " + lastName + ", First Name: " + firstName);
            }

            // Close resources
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // Handle JDBC errors
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // Finally block used to close resources
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("End of execution.");
    }
}
