package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.sql.SQLException;


public class Controller {

    AutocamperDao autocamperDao = new AutocamperDaoImpl();

    @FXML
    Button rent;

    @FXML
    ListView<Autocamper> lv;
    
    @FXML
    public void generateList() throws SQLException {
        lv.setItems(autocamperDao.getAllAutocamper());
    }
}
