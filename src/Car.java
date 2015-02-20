/**
 * The Car class represents data type that describes abstract car. The instance of Car is created
 * by usage of CarBuilder class.
 */

public class Car implements Comparable<Car>{
    private final String brand;
    private final int maxSpeed;
    private final int priceCost;
    private final double fuelConsumption;

    protected Car (CarBuilder builder){
        this.brand = builder.brand;
        this.maxSpeed = builder.maxSpeed;
        this.fuelConsumption = builder.fuelConsumption;
        this.priceCost = builder.priceCost;
    }

    public static class CarBuilder{
        protected final String brand;
        protected int maxSpeed = 0;
        protected int priceCost = 0;
        protected double fuelConsumption = 0;

        public CarBuilder(String brand) {
            this.brand = brand;
        }

        public CarBuilder maxSpeed(int value){
            maxSpeed = value;
            return this;
        }

        public CarBuilder fuelConsumption(double value){
            fuelConsumption = value;
            return this;
        }

        public CarBuilder priceCost(int value){
            priceCost = value;
            return this;
        }

        public Car build(){
            return new Car(this);
        }
    }

    public int getPriceCost(){
        return this.priceCost;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public int getMaxSpeed(){
        return this.maxSpeed;
    }

    @Override
    public int compareTo(Car car) {
        if (this.fuelConsumption > car.fuelConsumption){
            return 1;
        }
        else if (this.fuelConsumption == car.fuelConsumption){
            return 0;
        }
        else {
            return -1;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (Double.compare(car.fuelConsumption, fuelConsumption) != 0) return false;
        if (maxSpeed != car.maxSpeed) return false;
        if (priceCost != car.priceCost) return false;
        if (brand != null ? !brand.equals(car.brand) : car.brand != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = brand != null ? brand.hashCode() : 0;
        result = 31 * result + maxSpeed;
        result = 31 * result + priceCost;
        temp = Double.doubleToLongBits(fuelConsumption);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Марка: " + brand + ", стоимость:  " + priceCost + ", Макс. скорость:  " + maxSpeed
                + ", средний расход:  " + fuelConsumption;
    }
}
