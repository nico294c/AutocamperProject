package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentalDaoImpl implements RentalDao {

    ObservableList<Rental> rentalObservableList = FXCollections.observableArrayList();
    Connection connection;

    @Override
    public void addRental(Rental rental) throws SQLException {
        connection = MyDatabase.openConnection();

        assert connection != null;

        insertRental(rental, connection);

        MyDatabase.closeConnection(connection);
    }

    static int insertRental(Rental rental, Connection connection) throws SQLException {
        int i;
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO tbl_Rentals VALUES (?,?,?,?,?,?)");
        rental.setRentalId();
        preparedStatement.setInt(1, rental.getRentalId());
        preparedStatement.setInt(2, rental.getWeek());
        preparedStatement.setInt(3, rental.getDuration());
        preparedStatement.setInt(4, rental.isDepositStatus());
        preparedStatement.setInt(5, rental.getAutocamperId());
        preparedStatement.setInt(6, rental.getCustomerId());

        i = preparedStatement.executeUpdate();
        return i;
    }

    @Override
    public void updateRental(Rental rental) {

    }

    @Override
    public void deleteRental(Rental rental) {

    }

    @Override
    public List<Rental> getAllRental() {
        return null;
    }
}
