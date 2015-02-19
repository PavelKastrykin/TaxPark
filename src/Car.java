
public class Car implements Comparable<Car>{
    private String brand;
    private int maxSpeed;
    private int priceCost;
    private double fuelConsumption;

    public Car (String brand, int maxSpeed, double fuelConsumption, int priceCost){
        this.brand = brand;
        this.maxSpeed = maxSpeed;
        this.fuelConsumption = fuelConsumption;
        this.priceCost = priceCost;
    }

    public int getPriceCost(){
        return this.priceCost;
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
    public boolean equals(Object obj) {
        if (!(obj instanceof Car)){
            return false;
        }
        else if (this == (Car)obj){
            return true;
        }
        else {
            Car x = (Car)obj;
            return (x.brand.equals(this.brand) && x.maxSpeed == this.maxSpeed &&
                    x.priceCost == this.priceCost);
        }

    }

    @Override
    public String toString() {
        return "Марка: " + brand + ", стоимость:  " + priceCost + ", Макс. скорость:  " + maxSpeed
                + ", средний расход:  " + fuelConsumption;
    }
}
