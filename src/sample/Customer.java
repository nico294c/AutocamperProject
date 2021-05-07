package sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer {
    private int customerId;
    private String telephoneNo;
    private String name;
    private String email;
    private String driversLicenceId;
    private String streetName;
    private int streetNumber;
    private String city;
    private String zipCode;
    private String country;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId() throws SQLException {
        Connection connection = MyDatabase.openConnection();
        PreparedStatement preparedStatement;
        int id = 0;
        try {
            assert connection != null;
            preparedStatement = connection.prepareStatement("SELECT MAX(fldCustomerID) from tbl_Customer");

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
        customerId = id;

    }

    public String getTelephoneNo() {
        return telephoneNo;
    }

    public void setTelephoneNo(String telephoneNo) {
        this.telephoneNo = telephoneNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDriversLicenceId() {
        return driversLicenceId;
    }

    public void setDriversLicenceId(String driversLicenceId) {
        this.driversLicenceId = driversLicenceId;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Customer(int customerId, String telephoneNo, String name, String email,
                    String streetName, int streetNumber,
                    String city, String zipCode, String country, String driversLicenceId) {
        this.customerId = customerId;
        setTelephoneNo(telephoneNo);
        setName(name);
        setEmail(email);
        setDriversLicenceId(driversLicenceId);
        setStreetName(streetName);
        setStreetNumber(streetNumber);
        setCity(city);
        setZipCode(zipCode);
        setCountry(country);
    }

    @Override
    public String toString() {
        String customerString = "ID: " + customerId + " Name: " + name + " PhoneNo: " + telephoneNo + " Email: " + email;
        return customerString;
    }
}
