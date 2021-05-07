package sample;

import java.sql.SQLException;
import java.util.List;

public interface RentalDao {
    void addRental(Rental rental) throws SQLException;
    void updateRental(Rental rental);
    void deleteRental(Rental rental);
    List<Rental> getAllRental();
}
