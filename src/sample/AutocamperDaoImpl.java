package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutocamperDaoImpl implements AutocamperDao{

    ArrayList<Autocamper> autocamperArrayList = new ArrayList<>();
    Connection connection;

    @Override
    public void addAutocamper(Autocamper autocamper) throws SQLException {
        //Open connection and initialize it
        connection = MyDatabase.openConnection();

        assert connection != null;
        insertAutocamper(autocamper, connection);


        MyDatabase.closeConnection(connection);
    }

    static void insertAutocamper(Autocamper autocamper, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT into tbl_Autocamper VALUES (?,?,?,?,?,?,?,?)");

        preparedStatement.setInt(1, autocamper.getAutocamperID());
        preparedStatement.setInt(2, autocamper.getSize());
        preparedStatement.setFloat(3, (float) autocamper.getMileage());
        preparedStatement.setString(4, autocamper.getCondition().toString());
        preparedStatement.setString(5, autocamper.getAvailability().toString());
        preparedStatement.setInt(6, autocamper.getCapacity());
        preparedStatement.setString(7, autocamper.getKitchenType().toString());
        preparedStatement.setString(8, autocamper.getAutocamperType().toString());

        preparedStatement.execute();
    }

    @Override
    public void updateAutocamper(Autocamper autocamper) {

    }

    @Override
    public void deleteAutocamper(Autocamper autocamper) {

    }

    @Override
    public List<Autocamper> getAllAutocamper() {
        return null;
    }


}
