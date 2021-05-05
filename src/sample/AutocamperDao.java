package sample;

import java.sql.SQLException;
import java.util.List;

public interface AutocamperDao {
    void addAutocamper(Autocamper autocamper) throws SQLException;
    void updateAutocamper(Autocamper autocamper);
    void deleteAutocamper(Autocamper autocamper);
    List<Autocamper> getAllAutocamper() throws SQLException;
}
