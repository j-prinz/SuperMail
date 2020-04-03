package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import oracle.jdbc.driver.OracleDriver;

public class DatabaseConnection {

    public static void oracleDriverSetup() throws SQLException {
        try {
            DriverManager.registerDriver(new OracleDriver());
            System.out.println("Driver registered.");
        } catch (SQLException var2) {
            System.out.println("Unable to register driver.");
        }

    }
}