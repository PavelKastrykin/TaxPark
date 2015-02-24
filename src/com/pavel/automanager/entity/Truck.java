package com.pavel.automanager.entity;

/**
 * The subclass of Car base-class. Widens base-class with a field "load capacity".
 */
public class Truck extends Car{
    private int loadCapacity;

    public Truck(){};

    public Truck (String brand, int maxSpeed, int priceCost, double fuelConsumption, int loadCapacity){
        super(brand, maxSpeed, priceCost, fuelConsumption);
        this.loadCapacity = loadCapacity;
    }
    public int getLoadCapacity(){
        return this.loadCapacity;
    }

    public void setLoadCapacity(int value){
        this.loadCapacity = value;
    }

    @Override
    public String toString(){
        return super.toString() + ", load capacity: " + loadCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Truck truck = (Truck) o;

        if (loadCapacity != truck.loadCapacity) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + loadCapacity;
        return result;
    }
}
