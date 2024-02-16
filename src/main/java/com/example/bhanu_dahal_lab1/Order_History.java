package com.example.bhanu_dahal_lab1;



public class Order_History {
    private int OrderID;
    private String UserName;
    private String Email;
    private String Adress;

    public  Order_History(int OrderID, String UserName,String Email,String Adress) {
        this.OrderID = OrderID;
        this.UserName = UserName;
        this.Email = Email;
        this.Adress = Adress;

    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int orderID) {
        OrderID = orderID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }
}
