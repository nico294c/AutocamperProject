package sample;

import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDao {
    void addCustomer(Customer customer) throws SQLException;

    void updateCustomer(Customer customer);

    void deleteCustomer(Customer customer);

    ObservableList<Customer> getAllCustomer() throws SQLException;
}
