package sample;

public class Autocamper {
    private enum condition{
        Perfect, Good, SlightlyUsed, VeryUsed
    }
    private enum availability{
        Rented, Available, Unavailable
    }
    private enum kitchenType{
    BigKitchen, SmallKitchen, NoKitchen
    }
    private kitchenType kitchenType;
    private availability availability;
    private condition condition;
    private double mileage;
    private double size;
    private int capacity;

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

    public Autocamper(double mileage, double size, int capacity, availability availability, condition condition, kitchenType kitchenType){
        setAvailability(availability);
        setCondition(condition);
        setKitchenType(kitchenType);
        setMileage(mileage);
        setCapacity(capacity);
        setSize(size);
    }
}
