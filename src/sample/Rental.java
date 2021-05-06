package sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Rental {

    private int rentalId;
    private int week;
    private int duration;
    private int customerId;
    private boolean depositStatus;
    private int autocamperId;

    public int getRentalId() {
        return rentalId;
    }

    public int setRentalId() throws SQLException {
        Connection connection = MyDatabase.openConnection();
        PreparedStatement preparedStatement;
        int id = 0;
        try {
            assert connection != null;
            preparedStatement = connection.prepareStatement("SELECT MAX(fldRentalID) from tbl_Rentals");

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet == null) {
                id = 1;
            }
            if (resultSet.next()) {
                id = resultSet.getInt(1) + 1;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        MyDatabase.closeConnection(connection);
        rentalId = id;
        return rentalId;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int isDepositStatus() {
        int i;
        return i = depositStatus ? 1 : 0;
    }

    public void setDepositStatus(boolean depositStatus) {
        this.depositStatus = depositStatus;
    }

    public int getAutocamperId() {
        return autocamperId;
    }

    public void setAutocamperId(int autocamperId) {
        this.autocamperId = autocamperId;
    }

    public Rental(int rentalId, int week, int duration, int customerId, boolean depositStatus, int autocamperId) {
        this.rentalId = rentalId;
        setAutocamperId(autocamperId);
        setCustomerId(customerId);
        setDepositStatus(depositStatus);
        setWeek(week);
        setDuration(duration);
    }
}
