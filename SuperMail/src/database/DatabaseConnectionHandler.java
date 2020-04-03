package database;

import model.DeliveryOrderModel;
import java.sql.*;
import java.util.ArrayList;

/**
 * This class handles all database related transactions
 */
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

    public void deleteOrder(int orderId) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM DeliveryOrder WHERE Order_ID = ?");
            ps.setInt(1, orderId);

            int rowCount = ps.executeUpdate();
            if (rowCount == 0) {
                System.out.println(WARNING_TAG + " Order number " + orderId + " does not exist!");
            }

            connection.commit();

            ps.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            rollbackConnection();
        }
    }

    public void insertOrder(DeliveryOrderModel model) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO DeliveryOrder VALUES (?,?,?,?,?,?,?)");
            ps.setInt(1, model.getOrder_ID());
            ps.setInt(2, model.getCustomer_ID());
            ps.setInt(3, model.getEID());
            ps.setString(4, model.getDate());
            ps.setString(5, model.getDelivery_Status());
            ps.setDouble(6, model.getPricing());
            ps.setInt(7, model.getReceiver_ID());

            ps.executeUpdate();
            connection.commit();

            ps.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            rollbackConnection();
        }
    }

    public DeliveryOrderModel[] getOrderInfo() {
        ArrayList<DeliveryOrderModel> result = new ArrayList<DeliveryOrderModel>();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM DeliveryOrder");

            while(rs.next()) {
                DeliveryOrderModel model = new DeliveryOrderModel(
                        rs.getInt("Order_ID"),
                        rs.getInt("Customer_ID"),
                        rs.getInt("EID"),
                        rs.getString("INITIAL_DATE"),
                        rs.getString("Delivery_Status"),
                        rs.getDouble("Pricing"),
                        rs.getInt("Receiver_ID")
                );
                result.add(model);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }

        return result.toArray(new DeliveryOrderModel[result.size()]);
    }

//    public void updateBranch(int id, String name) {
//        try {
//          PreparedStatement ps = connection.prepareStatement("UPDATE branch SET branch_name = ? WHERE branch_id = ?");
//          ps.setString(1, name);
//          ps.setInt(2, id);
//
//          int rowCount = ps.executeUpdate();
//          if (rowCount == 0) {
//              System.out.println(WARNING_TAG + " Branch " + id + " does not exist!");
//          }
//
//          connection.commit();
//
//          ps.close();
//        } catch (SQLException e) {
//            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
//            rollbackConnection();
//        }
//    }

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

    private void rollbackConnection() {
        try  {
            connection.rollback();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
    }

    public void databaseSetup() {
        dropBranchTableIfExists();

        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("CREATE TABLE DeliveryOrder ( Order_ID INT PRIMARY KEY, Customer_ID INT, EID INT, INITIAL_DATE DATE, Delivery_Status CHAR(10), Pricing REAL, Receiver_ID INT) ");
            stmt.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }

        DeliveryOrderModel order1 = new DeliveryOrderModel(1, 3, 104, "1-Apr-2020", "Delivered", 19.99, 6);
        insertOrder(order1);

        DeliveryOrderModel order2 = new DeliveryOrderModel(2, 3, 105, "2-Apr-2020", "Delivered", 9.99, 4);
        insertOrder(order2);

    }

    private void dropBranchTableIfExists() {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select table_name from user_tables");

            while(rs.next()) {
                if(rs.getString(1).toLowerCase().equals("deliveryorder")) {
                    stmt.execute("DROP TABLE DeliveryOrder");
                    break;
                }
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
    }
}
