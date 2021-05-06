package sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Autocamper {
    public enum condition{
        Perfect(0), Good(1), SlightlyUsed(2), VeryUsed(3);

        private final int value;
        private condition(int value){
            this.value = value;
        }
        public int getValue(){
            return value;
        }

        public static condition getEnum(int i){
            switch (i){
                case 0:
                    return Perfect;
                case 1:
                    return Good;
                case 2:
                    return  SlightlyUsed;
                case 3:
                    return VeryUsed;
                default:
                    return null;
            }
        }

    }
    public enum availability{
        Rented(0), Available(1), Unavailable(2);

        private final int value;
        private availability(int value){
            this.value = value;
        }
        public int getValue(){
            return value;
        }
        public static availability getEnum(int i){
            switch (i){
                case 0:
                    return Rented;
                case 1:
                    return Available;
                case 2:
                    return  Unavailable;
                default:
                    return null;
            }
        }
    }
    public enum kitchenType{
        BigKitchen(0), SmallKitchen(1), NoKitchen(2);

        private final int value;
        private kitchenType(int value){
            this.value = value;
        }
        public int getValue(){
            return value;
        }

        public static kitchenType getEnum(int i){
            switch (i){
                case 0:
                    return BigKitchen;
                case 1:
                    return SmallKitchen;
                case 2:
                    return  NoKitchen;
                default:
                    return null;
            }
        }
    }
    public enum autocamperType{
        Basic(0), Standard(1), Luxury(2);

        private final int value;
        private autocamperType(int value){
            this.value = value;
        }
        public int getValue(){
            return value;
        }

        public static autocamperType getEnum(int i){
            switch (i){
                case 0:
                    return Basic;
                case 1:
                    return Standard;
                case 2:
                    return  Luxury;
                default:
                    return null;
            }
        }
    }

    private autocamperType autocamperType;
    private kitchenType kitchenType;
    private availability availability;
    private condition condition;
    private int mileage;
    private int size;
    private int capacity;
    private int autocamperID;

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

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
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

    public int getAutocamperID() {
        return this.autocamperID;
    }

    public void setAutocamperID() throws SQLException {
        Connection connection = MyDatabase.openConnection();
        PreparedStatement preparedStatement = null;
        int id = 0;
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

        autocamperID = id;

    }

    public Autocamper(int autocamperID, int size, int mileage, condition condition, availability availability, int capacity,
                        kitchenType kitchenType, autocamperType autocamperType)throws SQLException{
        this.autocamperID = autocamperID;
        setAvailability(availability);
        setCondition(condition);
        setKitchenType(kitchenType);
        setMileage(mileage);
        setCapacity(capacity);
        setSize(size);
        setAutocamperType(autocamperType);
    }


    @Override
    public String toString(){
        return "ID: " + getAutocamperID() +" Type: " + getAutocamperType() +" Size: " + getSize() + " Mileage:  " + getMileage()
                + " Condition: " + getCondition() + " Available: " + getAvailability()
                + " Capacity: " + getCapacity() + " Kitchen: " + getKitchenType();
    }


}
