package com.pavel.automanager.entity.baseclass;

/**
 * The Car class represents data type that describes abstract car. The instance can be created with a paramrtric constructor,
 * and non-parametric constructor and list of getters/setters gives an ability to set instance values while in
 * process or by means of builder.
 *
 * Has overridden methods equals(), hashCode(), toString() and compareTo().
 */

public class Car implements Comparable<Car>{
    private String brand;
    private int maxSpeed;
    private int priceCost;
    private double fuelConsumption;

    public Car(){};

    public Car(String brand, int maxSpeed, int priceCost, double fuelConsumption){
        this.brand = brand;
        this.maxSpeed = maxSpeed;
        this.priceCost = priceCost;
        this.fuelConsumption = fuelConsumption;
    }

    public String getBrand(){
        return this.brand;
    }

    public void setBrand(String value){
        this.brand = value;
    }

    public int getPriceCost(){
        return this.priceCost;
    }

    public void setPriceCost(int value){
        this.priceCost = value;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double value){
        this.fuelConsumption = value;
    }

    public int getMaxSpeed(){
        return this.maxSpeed;
    }

    public void setMaxSpeed(int value){
        this.maxSpeed = value;
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

    /**
     *
     * @return String representation getClass().getName() + " Марка: " + brand + ", стоимость:  " + priceCost +
     * ", Макс. скорость:  " + maxSpeed + ", средний расход:  " + fuelConsumption
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName());
        sb.append(" Марка: ").append(brand);
        sb.append(", стоимость:  ").append(priceCost);
        sb.append(", Макс. скорость:  ").append(maxSpeed);
        sb.append(", средний расход:  ").append(fuelConsumption);
        return sb.toString();
    }
}

