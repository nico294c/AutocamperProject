package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Controller {
    Connection connection;


    AutocamperDao autocamperDao = new AutocamperDaoImpl();
    CustomerDao customerDao = new CustomerDaoImpl();
    RentalDao rentalDao = new RentalDaoImpl();
    ObservableList<Autocamper> autocamperObservableList = FXCollections.observableArrayList();
    ObservableList<Customer> customerObservableList = FXCollections.observableArrayList();

    int condition, kitchenType, autocamperType;

    @FXML
    Button rent;
    @FXML
    Button refreshAutocamper;
    @FXML
    Button refreshCustomer;
    @FXML
    Button createCustomerButton;

    @FXML
    MenuButton camperMenuButton;
    @FXML
    MenuButton kitchenMenuButton;
    @FXML
    MenuButton conditionMenuButton;

    @FXML
    MenuItem basic = new MenuItem("Basic");
    @FXML
    MenuItem standard = new MenuItem("Standard");
    @FXML
    MenuItem luxury = new MenuItem("Luxury");
    @FXML
    MenuItem perfect = new MenuItem("Perfect");
    @FXML
    MenuItem good = new MenuItem("Good");
    @FXML
    MenuItem slightlyUsed = new MenuItem("Slightly Used");
    @FXML
    MenuItem veryUsed = new MenuItem("Very Used");
    @FXML
    MenuItem bigKitchen = new MenuItem("Big Kitchen");
    @FXML
    MenuItem smallKitchen = new MenuItem("Small Kitchen");
    @FXML
    MenuItem noKitchen = new MenuItem("No Kitchen");



    @FXML
    ListView<Autocamper> lv;
    @FXML
    ListView<Customer> customerListView;
    @FXML
    ListView<Autocamper> chosenAutocamper;
    @FXML
    ListView<Customer> chosenCustomer;

    @FXML
    TextField startWeek;
    @FXML
    TextField durationWeeks;
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
    TextField size;
    @FXML
    TextField mileage;
    @FXML
    TextField capacity;

    @FXML
    public void basic(){
        camperMenuButton.setText("Basic");
        autocamperType = 0;
    }
    @FXML
    public void standard(){
        camperMenuButton.setText("Standard");
        autocamperType = 1;
    }
    @FXML
    public void luxury(){
        camperMenuButton.setText("Luxury");
        autocamperType = 2;
    }
    @FXML
    public void perfect(){
        conditionMenuButton.setText("Perfect");
        condition = 0;
    }
    @FXML
    public void good(){
        conditionMenuButton.setText("Good");
        condition = 1;
    }
    @FXML
    public void slightlyUsed(){
        conditionMenuButton.setText("Slightly Used");
        condition = 2;
    }
    @FXML
    public void veryUsed(){
        conditionMenuButton.setText("Very Used");
        condition = 3;
    }
    @FXML
    public void bigKitchen(){
        kitchenMenuButton.setText("Big Kitchen");
        kitchenType = 0;
    }
    @FXML
    public void smallKitchen(){
        kitchenMenuButton.setText("Small Kitchen");
        kitchenType = 1;
    }
    @FXML
    public void noKitchen(){
        kitchenMenuButton.setText("No Kitchen");
        kitchenType = 2;
    }



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
    public void addAutocamper() throws SQLException {
        Autocamper autocamper = new Autocamper(0,
                Integer.parseInt(size.getText()),
                Integer.parseInt(mileage.getText()),
                Autocamper.condition.getEnum(condition),
                Autocamper.availability.Available,
                Integer.parseInt(capacity.getText()),
                Autocamper.kitchenType.getEnum(kitchenType),
                Autocamper.autocamperType.getEnum(autocamperType));

        autocamperDao.addAutocamper(autocamper);
    }

    @FXML
    public void rentAutocamper() throws SQLException {
        int customerID, autocamperID;
        customerID = customerObservableList.get(0).getCustomerId();
        autocamperID = autocamperObservableList.get(0).getAutocamperID();

        Rental rental = new Rental(0, Integer.parseInt(startWeek.getText()),
                Integer.parseInt(durationWeeks.getText()),
                customerID, false, autocamperID);

        rentalDao.addRental(rental);
    }

    @FXML
    public void createCustomer() throws SQLException {
        Customer customer = new Customer(0, phoneNo.getText(), name.getText(), email.getText(),
                streetName.getText(), Integer.parseInt(streetNo.getText()),
                city.getText(), zipCode.getText(), country.getText(), licence.getText());


        customerDao.addCustomer(customer);

    }

    @FXML
    public void viewChosenCamper() {
        this.chosenAutocamper.getItems().clear();
        Autocamper chosenAutocamper = lv.getSelectionModel().getSelectedItem();

        autocamperObservableList.add(chosenAutocamper);

        this.chosenAutocamper.setItems(autocamperObservableList);
    }

    @FXML
    public void viewChosenCustomer() {
        this.chosenCustomer.getItems().clear();
        Customer chosenCustomer = customerListView.getSelectionModel().getSelectedItem();
        customerObservableList.add(chosenCustomer);
        this.chosenCustomer.setItems(customerObservableList);

    }



}






