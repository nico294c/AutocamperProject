package sample;

import java.util.Date;

public class Rental {

    private int rentalId;
    private Date startDate;
    private int duration;
    private int customerId;
    private boolean depositStatus;
    private int autocamperId;

    public int getRentalId() {
        return rentalId;
    }
    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
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

    public boolean isDepositStatus() {
        return depositStatus;
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

    public Rental(int rentalId, Date date, int duration, int customerId, boolean depositStatus, int autocamperId){
        setRentalId(rentalId);
        setAutocamperId(autocamperId);
        setCustomerId(customerId);
        setDepositStatus(depositStatus);
        setStartDate(date);
        setDuration(duration);
    }
}
