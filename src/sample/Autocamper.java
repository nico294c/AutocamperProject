package sample;

public class Autocamper {
    public enum condition{
        Perfect, Good, SlightlyUsed, VeryUsed
    }
    public enum availability{
        Rented, Available, Unavailable
    }
    public enum kitchenType{
    BigKitchen, SmallKitchen, NoKitchen
    }
    public enum autocamperType{
        Basic, Standard, Luxury
    }

    private autocamperType autocamperType;
    private kitchenType kitchenType;
    private availability availability;
    private condition condition;
    private double mileage;
    private double size;
    private int capacity;
    private int autocamperId;

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

    public double getMileage() {
        return mileage;
    }
    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public double getSize() {
        return size;
    }
    public void setSize(double size) {
        this.size = size;
    }

    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Autocamper.autocamperType getAutocamperType() {
        return autocamperType;
    }
    public void setAutocamperType(Autocamper.autocamperType autocamperType) {
        this.autocamperType = autocamperType;
    }

    public int getAutocamperId() {
        return autocamperId;
    }
    public void setAutocamperId(int autocamperId) {
        this.autocamperId = autocamperId;
    }

    public Autocamper(int autocamperId, double mileage, double size, int capacity, availability availability, condition condition, kitchenType kitchenType, autocamperType autocamperType){
        setAvailability(availability);
        setCondition(condition);
        setKitchenType(kitchenType);
        setMileage(mileage);
        setCapacity(capacity);
        setSize(size);
        setAutocamperId(autocamperId);
        setAutocamperType(autocamperType);
    }
}
