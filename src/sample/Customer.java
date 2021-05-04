package sample;

public class Customer {
    private int customerId;
    private String telephoneNo;
    private String name;
    private String email;
    private String driversLicenceId;
    private String address;

    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public Customer(int customerId, String telephoneNo, String name, String email, String driversLicenceId, String address){
        setCustomerId(customerId);
        setTelephoneNo(telephoneNo);
        setName(name);
        setEmail(email);
        setDriversLicenceId(driversLicenceId);
        setAddress(address);
    }
}
