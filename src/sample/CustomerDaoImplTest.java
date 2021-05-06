package sample;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class CustomerDaoImplTest {

    @Test
    void insertCustomer() throws SQLException {
        //Setup Test
        Customer customer = new Customer(1, "20202021", "Sarah Jensen", "Sarah.Jensen@gmail.com", "98456781",
                "Baker Street", 5, "Bageson", "1002", "Amerdenarmki");

        int actual;
        int expected = 1;
        Connection connection = MyDatabase.openConnection();

        //Run test
        assert connection != null;
        actual = CustomerDaoImpl.insertCustomer(customer, connection);



        //Assertion
        assertEquals(expected, actual);
    }
}