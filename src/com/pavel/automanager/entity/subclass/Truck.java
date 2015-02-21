package com.pavel.automanager.entity.subclass;

import com.pavel.automanager.entity.baseclass.*;

public class Truck extends Car{
    private final int loadCapacity;

    public Truck (String brand, int maxSpeed, int priceCost, double fuelConsumption, int loadCapacity){
        super(brand, maxSpeed, priceCost, fuelConsumption);
        this.loadCapacity = loadCapacity;
    }
    public int getCapacity(){
        return this.loadCapacity;
    }

    @Override
    public String toString(){
        return super.toString() + ", грузоподъемность: " + loadCapacity;
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
