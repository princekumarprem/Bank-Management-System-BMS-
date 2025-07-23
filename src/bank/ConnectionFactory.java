package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionFactory {
    // Make public if you want to access from outside
    public Connection con;
    public Statement stmt;

    public ConnectionFactory() {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Correct JDBC URL syntax
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bankmanagement",  // ✅ fixed
                "root",                                          // ✅ your username
                "pkp12345"                                       // ✅ your password
            );

            // Create statement object
            stmt = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

