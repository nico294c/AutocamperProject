package sample;

public class Invoice {

    private int invoiceId;
    private int rentalId;
    private double totalAmountDue;
    private double depositAmount;

    public int getInvoiceID() {
        return invoiceId;
    }
    public void setInvoiceID(int invoiceID) {
        this.invoiceId = invoiceID;
    }

    public int getRentalID() {
        return rentalId;
    }
    public void setRentalID(int rentalID) {
        this.rentalId = rentalID;
    }

    public double getTotalAmountDue() {
        return totalAmountDue;
    }
    public void setTotalAmountDue(double totalAmountDue) {
        this.totalAmountDue = totalAmountDue;
    }

    public double getDepositAmount() {
        return depositAmount;
    }
    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    private int generateID(){
        int n = 0;
        return n;
    }

    public Invoice(int invoiceId, int rentalId, double totalAmountDue, double depositAmount){
        setInvoiceID(invoiceId);
        setRentalID(rentalId);
        setDepositAmount(depositAmount);
        setTotalAmountDue(totalAmountDue);
    }
}
