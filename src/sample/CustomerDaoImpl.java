package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao{
    ObservableList<Customer> customers = FXCollections.observableArrayList();
    Connection connection;

    @Override
    public void addCustomer(Customer customer) throws SQLException {
        connection = MyDatabase.openConnection();
        assert connection!= null;

        insertCustomer(customer, connection);

        MyDatabase.closeConnection(connection);
    }
    static int insertCustomer(Customer customer, Connection connection) throws SQLException {
        int i = 0;
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT into tbl_Customer VALUES (?,?,?,?,?,?,?,?,?,?)");
        customer.setCustomerId();
        preparedStatement.setInt(1, customer.getCustomerId());
        preparedStatement.setString(2, customer.getTelephoneNo());
        preparedStatement.setString(3, customer.getName());
        preparedStatement.setString(4, customer.getEmail());
        preparedStatement.setString(5, customer.getStreetName());
        preparedStatement.setInt(6, customer.getStreetNumber());
        preparedStatement.setString(7, customer.getCity());
        preparedStatement.setString(8, customer.getZipCode());
        preparedStatement.setString(9, customer.getCountry());
        preparedStatement.setString(10, customer.getDriversLicenceId());

        i = preparedStatement.executeUpdate();
        return i;

    }

    @Override
    public void updateCustomer(Customer customer) {

    }

    @Override
    public void deleteCustomer(Customer customer) {

    }

    @Override
    public ObservableList<Customer> getAllCustomer() throws SQLException {
        connection = MyDatabase.openConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM tbl_Customer");

        ResultSet resultSet = preparedStatement.executeQuery();


        while (resultSet.next()){
            customers.add(new Customer(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getInt(6),
                    resultSet.getString(7),
                    resultSet.getString(8),
                    resultSet.getString(9),
                    resultSet.getString(10)));


        }
        for (Customer c: customers) {
            System.out.println(c.getCustomerId());
        }
        MyDatabase.closeConnection(connection);
        return customers;
    }
}



