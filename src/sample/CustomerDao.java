package sample;

import java.util.List;

public interface CustomerDao {
    void addCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(Customer customer);
    List<Customer> getAllCustomer(Customer customer);
}
