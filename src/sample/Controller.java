package sample;

import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Controller {
    Connection connection;



   AutocamperDao autocamperDao = new AutocamperDaoImpl();
   CustomerDao customerDao = new CustomerDaoImpl();

    @FXML
    Button rent;
    @FXML
    Button refreshAutocamper;
    @FXML
    Button refreshCustomer;
    @FXML
    Button createCustomerButton;

    @FXML
    ListView<Autocamper> lv;
    @FXML
    ListView<Customer> customerListView;

    @FXML
    TextField customerID;
    @FXML
    TextField name;
    @FXML
    TextField phoneNo;
    @FXML
    TextField email;
    @FXML
    TextField streetName;
    @FXML
    TextField streetNo;
    @FXML
    TextField zipCode;
    @FXML
    TextField city;
    @FXML
    TextField country;
    @FXML
    TextField licence;

    
    @FXML
    public void generateList() throws SQLException {
        lv.getItems().clear();
        lv.setItems(autocamperDao.getAllAutocamper());
    }
    @FXML
    public void generateCustomerList() throws SQLException {
        customerListView.getItems().clear();
        customerListView.setItems(customerDao.getAllCustomer());

    }

    @FXML
    public void createCustomer() throws SQLException {
        CustomerDao customerDao = new CustomerDaoImpl();
        Customer customer = new Customer(0, phoneNo.getText(), name.getText(), email.getText(),
                streetName.getText(),Integer.parseInt(streetNo.getText()),
                city.getText(), zipCode.getText(),country.getText(), licence.getText());
        customer.setCustomerId();
//        customer.setTelephoneNo(phoneNo.getText());
//        customer.setName(name.getText());
//        customer.setEmail(email.getText());
//        customer.setStreetName(streetName.getText());
//        customer.setStreetNumber(Integer.parseInt(streetNo.getText()));
//        customer.setCity(city.getText());
//        customer.setZipCode(zipCode.getText());
//        customer.setCountry(country.getText());
//        customer.setDriversLicenceId(licence.getText());

        customerDao.addCustomer(customer);

    }

    @FXML
    public void rentAutocamper() throws SQLException{

    }



    }






