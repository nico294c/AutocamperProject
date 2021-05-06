package sample;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDao {
    void addCustomer(Customer customer) throws SQLException;
    void updateCustomer(Customer customer);
    void deleteCustomer(Customer customer);
    List<Customer> getAllCustomer(Customer customer);
}
