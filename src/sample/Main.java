package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Autocamper");
        primaryStage.setScene(new Scene(root, 600, 800));
        primaryStage.show();

        AutocamperDao hej = new AutocamperDaoImpl();

//
//        hej.addAutocamper(new Autocamper(1,2,
//                Autocamper.condition.Perfect, Autocamper.availability.Available,
//                3, Autocamper.kitchenType.BigKitchen, Autocamper.autocamperType.Luxury ));

        hej.getAllAutocamper();

        primaryStage.close();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
