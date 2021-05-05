package sample;

public class Insurance {
    public enum insuranceType{
        Basic, SuperCoverPlus
    }
    private double insurancePrice;
    private insuranceType insuranceType;

    public double getInsurancePrice() {
        return insurancePrice;
    }
    public void setInsurancePrice(double insurancePrice) {
        this.insurancePrice = insurancePrice;
    }

    public Insurance.insuranceType getInsuranceType() {
        return insuranceType;
    }
    public void setInsuranceType(Insurance.insuranceType insuranceType) {
        this.insuranceType = insuranceType;
    }

    public Insurance(insuranceType insuranceType, double insurancePrice){
        setInsuranceType(insuranceType);
        setInsurancePrice(insurancePrice);
    }
}
