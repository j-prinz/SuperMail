package db.handler;

import model.ItemsModel;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseConnectionHandler {

    // Use this version of the ORACLE_URL if you are running the code off of the server
    private static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1522:stu";

    private static final String EXCEPTION_TAG = "[EXCEPTION]";
    private static final String WARNING_TAG = "[WARNING]";

    private Connection connection = null;

    public DatabaseConnectionHandler() {
        try {
            // Load the Oracle JDBC driver
            // Note that the path could change for new drivers
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
    }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
    }

    public boolean login(String username, String password) {
        try {
            if (connection != null) {
                connection.close();
            }

            connection = DriverManager.getConnection(ORACLE_URL, username, password);
            connection.setAutoCommit(false);

            System.out.println("\nConnected to Oracle!");
            return true;
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            return false;
        }
    }

    public void insertItem(ItemsModel model) {

    }

    public void databaseSetup() {
//        dropBranchTableIfExists();

        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("CREATE TABLE items (item_ID integer PRIMARY KEY, order_ID varchar2(20) not null, branch_addr varchar2(50), branch_city varchar2(20) not null, branch_phone integer)");
            stmt.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }

        ItemsModel item1 = new ItemsModel(1,101,25,26,27,12,true);
        insertItem(item1);

        ItemsModel item2 = new ItemsModel(2,105,5,6,7,9,false);
        insertItem(item2);
    }

//    private void dropBranchTableIfExists() {
//        try {
//            Statement stmt = connection.createStatement();
//            ResultSet rs = stmt.executeQuery("select table_name from user_tables");
//
//            while(rs.next()) {
//                if(rs.getString(1).toLowerCase().equals("branch")) {
//                    stmt.execute("DROP TABLE Items");
//                    break;
//                }
//            }
//
//            rs.close();
//            stmt.close();
//        } catch (SQLException e) {
//            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
//        }
//    }


}
