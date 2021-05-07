package sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class AutocamperDaoImplTest {

    @org.junit.jupiter.api.Test
    void insertAutocamper() throws SQLException {
        //Setup Test
        Autocamper autocamper = new Autocamper(10, 35, 2, Autocamper.condition.Perfect, Autocamper.availability.Available, 3,
                Autocamper.kitchenType.BigKitchen, Autocamper.autocamperType.Standard);
        int actual;
        int expected = 1;
        Connection connection = MyDatabase.openConnection();

        //Run test
        assert connection != null;
        actual = AutocamperDaoImpl.insertAutocamper(autocamper, connection);

        //Assertion
        assertEquals(expected, actual);
    }
}