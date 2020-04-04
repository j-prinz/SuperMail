package database;

import model.DeliveryOrderModel;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

            this.connection.commit();

            ps.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            this.rollbackConnection();
        }
    }

    public void insertOrder(DeliveryOrderModel model) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO DeliveryOrder VALUES (?,?,?,?,?,?,?,?)");
            ps.setInt(1, model.getOrder_ID());
            ps.setInt(2, model.getCustomer_ID());
            ps.setInt(3, model.getEID());
            ps.setDate(4, model.getInitialDate());
            ps.setDate(5,model.getDeliveryDate());
            ps.setString(6, model.getDelivery_Status());
            ps.setDouble(7, model.getPricing());
            ps.setInt(8, model.getReceiver_ID());

            ps.executeUpdate();
            this.connection.commit();

            ps.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            this.rollbackConnection();
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
                        rs.getDate("INITIAL_DATE"),
                        rs.getDate("DELIVERY_DATE"),
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

        return result.toArray(new DeliveryOrderModel[0]);
    }

    public void updateOrder(int eid, int order_id) {
        try {
          PreparedStatement ps = connection.prepareStatement("UPDATE DeliveryOrder SET EID = ? WHERE ORDER_ID = ?");
          ps.setInt(1, eid);
          ps.setInt(2, order_id);

          int rowCount = ps.executeUpdate();
          if (rowCount == 0) {
              System.out.println(WARNING_TAG + " Employee " + eid + " does not exist!");
          }

          this.connection.commit();

          ps.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            this.rollbackConnection();
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

    private void rollbackConnection() {
        try  {
            connection.rollback();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
    }

    public void databaseSetup() {
        dropOrderTableIfExists();

        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("CREATE TABLE DeliveryOrder ( Order_ID INT PRIMARY KEY, Customer_ID INT, EID INT, INITIAL_DATE DATE, Delivery_Status CHAR(10), Pricing REAL, Receiver_ID INT) ");
            stmt.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }

        String initial_date_1 = "2020-04-01";
        String delivery_date_1 = "2020-04-20";
        String initial_date_2 = "2020-04-02";
        String delivery_date_2 = "2020-04-19";
        DeliveryOrderModel order1;
        DeliveryOrderModel order2;
        try {
            Date id1 = (Date) new SimpleDateFormat("yyyy-mm-dd").parse(initial_date_1);
            Date dd1 = (Date) new SimpleDateFormat("yyyy-mm-dd").parse(delivery_date_1);
            Date id2 = (Date) new SimpleDateFormat("yyyy-mm-dd").parse(initial_date_2);
            Date dd2 = (Date) new SimpleDateFormat("yyyy-mm-dd").parse(delivery_date_2);

            order1 = new DeliveryOrderModel(1, 3, 104, id1, dd1, "Delivered", 19.99, 6);
            this.insertOrder(order1);

            order2 = new DeliveryOrderModel(2, 3, 105, id2,dd2, "Delivered", 9.99, 4);
            this.insertOrder(order2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    private void dropOrderTableIfExists() {
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
