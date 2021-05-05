package sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Autocamper {
    public enum condition {
        Perfect, Good, SlightlyUsed, VeryUsed
    }

    public enum availability {
        Rented, Available, Unavailable
    }

    public enum kitchenType {
        BigKitchen, SmallKitchen, NoKitchen



    }

    public static void test(){
    }

    public enum autocamperType{
        Basic, Standard, Luxury

    }

    private kitchenType kitchenType;
    private availability availability;
    private condition condition;
    private autocamperType autocamperType;
    private double mileage;
    private int size;
    private int capacity;
    private int id;

    public Autocamper.kitchenType getKitchenType() {
        return kitchenType;
    }

    public void setKitchenType(Autocamper.kitchenType kitchenType) {
        this.kitchenType = kitchenType;
    }

    public Autocamper.availability getAvailability() {
        return availability;
    }

    public void setAvailability(Autocamper.availability availability) {
        this.availability = availability;
    }

    public Autocamper.condition getCondition() {
        return condition;
    }

    public void setCondition(Autocamper.condition condition) {
        this.condition = condition;
    }

    public Autocamper.autocamperType getAutocamperType(){return autocamperType;}

    public void setAutocamperType(Autocamper.autocamperType autocamperType) {
        this.autocamperType = autocamperType;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getID() {
        return id;
    }

    public int setID() throws SQLException {
        Connection connection = MyDatabase.openConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT MAX(fldAutocamperID) FROM tbl_Autocamper");


            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet==null){
                id = 1;
            }

            if (resultSet.next()) {
                //id is set equal to the current max id plus one.
                id = resultSet.getInt(1)+1;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        MyDatabase.closeConnection(connection);
        return id;
    }

    public Autocamper(double mileage, int size, int capacity, availability availability, condition
            condition, kitchenType kitchenType, autocamperType autocamperType) throws SQLException {
        setAvailability(availability);
        setCondition(condition);
        setKitchenType(kitchenType);
        setMileage(mileage);
        setCapacity(capacity);
        setSize(size);
        this.id = setID();
        setAutocamperType(autocamperType);
    }



}
