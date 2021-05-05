package sample;

import java.util.List;

public interface RentalDao {
    void addRental(Rental rental);
    void updateRental(Rental rental);
    void deleteRental(Rental rental);
    List<Rental> getAllRental();
}
