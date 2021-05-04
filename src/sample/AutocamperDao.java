package sample;

import java.util.List;

public interface AutocamperDao {
    void addAutocamper(Autocamper autocamper);
    void updateAutocamper(Autocamper autocamper);
    void deleteAutocamper(Autocamper autocamper);
    List<Autocamper> getAllAutocamper();
}
