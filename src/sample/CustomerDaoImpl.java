package sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao{
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
    public List<Customer> getAllCustomer(Customer customer) {
        return null;
    }
}
