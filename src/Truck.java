
public class Truck extends Car{
    private int loadCapacity = 1;

    public Truck (String brand, int maxSpeed, double fuelConsumption, int priceCost, int loadCapacity){
        super(brand, maxSpeed, fuelConsumption, priceCost);
        this.loadCapacity = loadCapacity;
    }

    public int getCapacity(){
        return this.loadCapacity;
    }

    @Override
    public String toString(){
        return super.toString() + ", грузоподъемность: " + loadCapacity;
    }
}
