package tema4.models;

public class Order {
  private int ID;
  private String orderDate;
  private String shippedDate;
  private String status;
  private String comments;
  private int customerID;

  public Order(
      int ID,
      String orderDate,
      String shippedDate,
      String status,
      String comments,
      int customerID) {
    this.ID = ID;
    this.orderDate = orderDate;
    this.shippedDate = shippedDate;
    this.status = status;
    this.comments = comments;
    this.customerID = customerID;
  }

  public int getID() {
    return ID;
  }

  public void setID(int ID) {
    this.ID = ID;
  }

  public String getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(String orderDate) {
    this.orderDate = orderDate;
  }

  public String getShippedDate() {
    return shippedDate;
  }

  public void setShippedDate(String shippedDate) {
    this.shippedDate = shippedDate;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public int getCustomerID() {
    return customerID;
  }

  public void setCustomerID(int customerID) {
    this.customerID = customerID;
  }

  @Override
  public String toString() {
    return "Order{" +
            "ID=" + ID +
            ", orderDate='" + orderDate + '\'' +
            ", shippedDate='" + shippedDate + '\'' +
            ", status='" + status + '\'' +
            ", comments='" + comments + '\'' +
            ", customerID=" + customerID +
            '}';
  }
}
