package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutocamperDaoImpl implements AutocamperDao {

    ObservableList<Autocamper> autocamperObservableList = FXCollections.observableArrayList();
    Connection connection;

    @Override
    public void addAutocamper(Autocamper autocamper) throws SQLException {
        //Open connection and initialize it
        connection = MyDatabase.openConnection();

        assert connection != null;
        insertAutocamper(autocamper, connection);


        MyDatabase.closeConnection(connection);
    }

    static int insertAutocamper(Autocamper autocamper, Connection connection) throws SQLException {
        int i;
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT into tbl_Autocamper VALUES (?,?,?,?,?,?,?,?)");
        autocamper.setAutocamperID();
        preparedStatement.setInt(1, autocamper.getAutocamperID());
        preparedStatement.setInt(2, autocamper.getSize());
        preparedStatement.setInt(3, autocamper.getMileage());
        preparedStatement.setInt(4, autocamper.getCondition().getValue());
        preparedStatement.setInt(5, autocamper.getAvailability().getValue());
        preparedStatement.setInt(6, autocamper.getCapacity());
        preparedStatement.setInt(7, autocamper.getKitchenType().getValue());
        preparedStatement.setInt(8, autocamper.getAutocamperType().getValue());

        i = preparedStatement.executeUpdate();
        return i;
    }

    @Override
    public void updateAutocamper(Autocamper autocamper) {

    }

    @Override
    public void deleteAutocamper(Autocamper autocamper) {

    }

    @Override
    public ObservableList<Autocamper> getAllAutocamper() throws SQLException {


        connection = MyDatabase.openConnection();
        assert connection != null;
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM tbl_Autocamper");

        ResultSet resultSet = preparedStatement.executeQuery();


        while (resultSet.next()) {
            autocamperObservableList.add(new Autocamper(
                    resultSet.getInt(1),
                    resultSet.getInt(2),
                    resultSet.getInt(3),
                    Autocamper.condition.getEnum(resultSet.getInt(4)),
                    Autocamper.availability.getEnum(resultSet.getInt(5)),
                    resultSet.getInt(6),
                    Autocamper.kitchenType.getEnum(resultSet.getInt(7)),
                    Autocamper.autocamperType.getEnum(resultSet.getInt(8))));


        }
        MyDatabase.closeConnection(connection);

        return autocamperObservableList;

    }


}
