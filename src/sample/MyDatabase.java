package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDatabase {

    public static Connection openConnection() {
        try {
            // (1) load the driver into memory

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // (2) establish Connection
            // Connection con= DriverManager.getConnection("jdbc:sqlserver://EASV-THA-Q418\\TH:1433;databaseName=DB_JAN","tha","123456");
            return DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=db_Autocamper", "sa", "123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    //Closes the current connection
    public static void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }
}
