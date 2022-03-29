package tema4.datahandlers;

import tema4.models.Customer;
import tema4.models.Order;

import java.sql.*;

public class DataHandler {

  private Connection databaseConnection;

  public DataHandler(Connection databaseConnection) {
    this.databaseConnection = databaseConnection;
  }

  public Customer getById(int id) throws SQLException {
    Statement statement = databaseConnection.createStatement();

    assert statement != null;
    ResultSet rs = statement.executeQuery("SELECT * FROM customers WHERE id = " + id + " ;\n");

    rs.next();

    return new Customer(
        rs.getInt(1),
        rs.getString("username"),
        rs.getString("last_name"),
        rs.getString("first_name"),
        rs.getString("phone"),
        rs.getString("address"),
        rs.getString("city"),
        rs.getString("postal_code"),
        rs.getString("country"));
  }

  public void getAllCustomers() throws SQLException {
    Statement statement = databaseConnection.createStatement();

    assert statement != null;
    ResultSet rs = statement.executeQuery("SELECT * FROM customers");

    while (true) {
      assert rs != null;
      if (!rs.next()) break;
      System.out.println(
          rs.getString(1)
              + " "
              + rs.getString(2)
              + " "
              + rs.getString(3)
              + " "
              + rs.getString(4)
              + " "
              + rs.getString(5)
              + " "
              + rs.getString(6)
              + " "
              + rs.getString(7)
              + " "
              + rs.getString(8)
              + " "
              + rs.getString(9));
    }
  }

  public void getAllProducts() throws SQLException {
    Statement statement = databaseConnection.createStatement();

    assert statement != null;
    ResultSet rs = statement.executeQuery("SELECT * FROM products");

    while (true) {
      assert rs != null;
      if (!rs.next()) break;
      System.out.println(
          rs.getInt(1)
              + " "
              + rs.getString(2)
              + " "
              + rs.getString(3)
              + " "
              + rs.getInt(4)
              + " "
              + rs.getDouble(5));
    }
  }

  public void getAllOrders() throws SQLException {
    Statement statement = databaseConnection.createStatement();

    assert statement != null;
    ResultSet rs = statement.executeQuery("SELECT * FROM orders");

    while (true) {
      assert rs != null;
      if (!rs.next()) break;
      System.out.println(
          rs.getString(1)
              + " "
              + rs.getString(2)
              + " "
              + rs.getString(3)
              + " "
              + rs.getString(4)
              + " "
              + rs.getString(5)
              + " "
              + rs.getInt(6));
    }
  }

  public void update(int id, Customer toCopyFrom) throws SQLException {
    Statement statement = databaseConnection.createStatement();

    assert statement != null;
    StringBuilder sb = new StringBuilder();

    sb.append("UPDATE customers SET username = ")
        .append("'" + toCopyFrom.getUsername() + "'")
        .append(", last_name = ")
        .append("'" + toCopyFrom.getLast_name() + "'")
        .append(", first_name = ")
        .append("'" + toCopyFrom.getFirst_name() + "'")
        .append(", phone = ")
        .append("'" + toCopyFrom.getPhone() + "'")
        .append(", address = ")
        .append("'" + toCopyFrom.getAddress() + "'")
        .append(", city = ")
        .append("'" + toCopyFrom.getCity() + "'")
        .append(", postal_code = ")
        .append("'" + toCopyFrom.getPostalCode() + "'")
        .append(", country = ")
        .append("'" + toCopyFrom.getCountry() + "'")
        .append(" WHERE id = " + id + ";\n");

    statement.executeUpdate(sb.toString());
  }

  public void insert(Customer customer) throws SQLException {

    PreparedStatement psw =
        databaseConnection.prepareStatement(
            "INSERT INTO `customers` (`id`, `username`, `last_name`, `first_name`, "
                + "`phone`, `address`, `city`, `postal_code`, `country`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);");

    psw.setInt(1, customer.getID());
    psw.setString(2, customer.getUsername());
    psw.setString(3, customer.getLast_name());
    psw.setString(4, customer.getFirst_name());
    psw.setString(5, customer.getPhone());
    psw.setString(6, customer.getAddress());
    psw.setString(7, customer.getCity());
    psw.setString(8, customer.getPostalCode());
    psw.setString(9, customer.getCountry());
    psw.execute();
  }

  public void delete(int id) throws SQLException {
    PreparedStatement statement =
        databaseConnection.prepareStatement("DELETE FROM customers WHERE id= " + id + ";\n");

    assert statement != null;

    statement.execute();
  }

  public void addOrderForCustomer(int id, Order order) throws SQLException {
    Statement statement = databaseConnection.createStatement();

    assert statement != null;
    ResultSet rs = statement.executeQuery("SELECT id FROM customers");

    while (true) {
      assert rs != null;
      if (!rs.next()) break;
      if (rs.getInt("id") == id) { // verificam daca exista customerul
        PreparedStatement psw =
            databaseConnection.prepareStatement(
                "INSERT INTO `orders` (`id`, `order_date`, `shipped_date`, `status`, "
                    + "`comments`, `customer_id`) VALUES (?, ?, ?, ?, ?, ?);");

        psw.setInt(1, order.getID());
        psw.setString(2, order.getOrderDate());
        psw.setString(3, order.getShippedDate());
        psw.setString(4, order.getStatus());
        psw.setString(5, order.getComments());
        psw.setInt(6, id);

        psw.execute();
      }
    }
  }

  public void viewAllOrdersCustomer(int id) throws SQLException {
    Statement customersStatement = databaseConnection.createStatement();

    assert customersStatement != null;
    ResultSet customersRs = customersStatement.executeQuery("SELECT id FROM customers");

    while (true) {
      assert customersRs != null;
      if (!customersRs.next()) break;

      if (customersRs.getInt("id") == id) { // verificam daca exista customerul
        Statement ordersStatement = databaseConnection.createStatement();

        assert ordersStatement != null;
        ResultSet ordersRs =
            ordersStatement.executeQuery("SELECT * FROM orders WHERE customer_id = " + id);

        while (true) {
          assert ordersRs != null;
          if (!ordersRs.next()) break;
          System.out.println(
              ordersRs.getString(1)
                  + " "
                  + ordersRs.getString(2)
                  + " "
                  + ordersRs.getString(3)
                  + " "
                  + ordersRs.getString(4)
                  + " "
                  + ordersRs.getString(5)
                  + " "
                  + ordersRs.getInt(6));
        }
      }
    }
  }

  public void updateStatusOrder(int id, String status) throws SQLException {
    Statement statement = databaseConnection.createStatement();

    assert statement != null;

    statement.executeUpdate("UPDATE orders SET status = '" + status + "' WHERE id = " + id);
  }

  public void addCommentsOrder(int id, String comments) throws SQLException {
    Statement statement = databaseConnection.createStatement();

    assert statement != null;

    statement.executeUpdate("UPDATE orders SET comments = '" + comments + "' WHERE id = " + id);
  }

  public void updateStockOnOrder(int id) throws SQLException {
    Statement orderDetStatement = databaseConnection.createStatement();

    assert orderDetStatement != null;
    ResultSet orderDetRs =
        orderDetStatement.executeQuery("SELECT id, product_code, quantity FROM orderdetails");

    while (orderDetRs.next()) {
      if (orderDetRs.getInt(1) == id) {
        int product_code = orderDetRs.getInt(2);
        int quantity = orderDetRs.getInt(3);

        Statement productsStatement = databaseConnection.createStatement();

        assert productsStatement != null;
        int initialStock = 0;
        ResultSet stockSet =
            databaseConnection
                .createStatement()
                .executeQuery("SELECT stock FROM products WHERE code = " + product_code + ";\n");

        stockSet.next();

        initialStock = stockSet.getInt(1);

        productsStatement.executeUpdate(
            "UPDATE products SET stock = "
                + (initialStock - quantity)
                + " WHERE code = "
                + product_code
                + ";\n");
      }
    }
  }
}
