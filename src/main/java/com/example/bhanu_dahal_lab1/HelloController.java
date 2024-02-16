package com.example.bhanu_dahal_lab1;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private TableView<Order_History> Order_History;
    @FXML
    private TableColumn<Order_History, Integer> OrderID;
    @FXML
    private TableColumn<Order_History, String> UserName;
    @FXML
    private TableColumn<Order_History, String> Email;
    @FXML
    private TableColumn<Order_History, String> Adress;
    ObservableList<Order_History> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        OrderID.setCellValueFactory(new PropertyValueFactory<>("OrderID"));
        UserName.setCellValueFactory(new PropertyValueFactory<>("UserName"));
        Email.setCellValueFactory(new PropertyValueFactory<>("Email"));
        Adress.setCellValueFactory(new PropertyValueFactory<>("Adress"));

        Order_History.setItems(list);
    }

    @FXML
    protected void onHelloButtonClick() {
        populateTable();
    }
    public void populateTable() {
        list.clear();
// Establish a database connection
        String jdbcUrl = "jdbc:mysql://localhost:3306/Orders";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
// Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM Order_History";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
// Populate the table with data from the database
            while (resultSet.next()) {
                int OrderID = resultSet.getInt("OrderID");
                String UserName = resultSet.getString("UserName");
                String Email = resultSet.getString("Email");
                String Adress = resultSet.getString("Adress");

                Order_History.getItems().add(new Order_History(OrderID, UserName, Email,
                        Adress));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
