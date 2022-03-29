package tema4;

import tema4.datahandlers.DataHandler;
import tema4.models.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
  public static void main(String[] args) throws SQLException {
    String connectionUrl = "jdbc:mysql://localhost:3306/database";
    String username = "root";
    String password = "root";

    Connection connection = DriverManager.getConnection(connectionUrl, username, password);

    DataHandler dataHandler = new DataHandler(connection);

    System.out.println(dataHandler.getById(11));

    System.out.println();

    dataHandler.getAllCustomers();

    System.out.println();

    dataHandler.update(
        11,
        new Customer(
            68,
            "Edi_better",
            "Edi",
            "Better",
            "0474747",
            "Str titu",
            "Focsani",
            "625400",
            "Romania"));

    dataHandler.getAllCustomers();

    System.out.println();

    // Functie comentata deoarece in urma testarilor anterioare eu deja am adaugat primary keys in
    // database si
    // se produc coliziuni la o a doua rulare

    // dataHandler.insert(new Customer(18, "Marius_x", "Marius", "Pamant",
    //       "087847383", "Str Victo", "Oradea", "646446", "Franta"));

    dataHandler.getAllCustomers();

    System.out.println();

    dataHandler.delete(13);

    dataHandler.getAllCustomers();

    System.out.println();

    // dataHandler.addOrderForCustomer(12, new Order(68, "2022-05-21", "2022-05-22",
    //       "FULFILLED", "very nice", 12));

    dataHandler.getAllOrders();

    System.out.println();

    dataHandler.viewAllOrdersCustomer(12);

    System.out.println();

    dataHandler.getAllProducts();

    dataHandler.updateStockOnOrder(81);

    System.out.println();

    dataHandler.getAllProducts();
  }
}
