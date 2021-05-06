package sample;

import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.List;

public interface AutocamperDao {
    void addAutocamper(Autocamper autocamper) throws SQLException;
    void updateAutocamper(Autocamper autocamper);
    void deleteAutocamper(Autocamper autocamper);
    ObservableList<Autocamper> getAllAutocamper() throws SQLException;
}
