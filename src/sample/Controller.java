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

    @FXML
    Button rent;
    @FXML
    Button refresh;

    @FXML
    ListView<Autocamper> lv;

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
    public void rentAutocamper(Customer customer) throws SQLException {
        CustomerDao customerDao = new CustomerDaoImpl();
        customer.setTelephoneNo(phoneNo.getText());
        customer.setName(name.getText());
        customer.setEmail(email.getText());
        customer.setStreetName(streetName.getText());
        customer.setStreetNumber(Integer.parseInt(streetNo.getText()));
        customer.setCity(city.getText());
        customer.setZipCode(zipCode.getText());
        customer.setCountry(country.getText());
        customer.setDriversLicenceId(licence.getText());

        customerDao.addCustomer(customer);


    }



    }






