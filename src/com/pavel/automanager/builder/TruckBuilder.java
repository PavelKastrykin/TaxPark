package com.pavel.automanager.builder;


import com.pavel.automanager.entity.subclass.Truck;

public class TruckBuilder extends CarBuilder{
    private Truck truck;
    private int loadCapacity;

    public TruckBuilder(String brand){
        super(brand);
    }

    public TruckBuilder setLoadCapacity(int value){
        this.loadCapacity = value;
        return this;
    }

    public Truck build(){
        truck = new Truck(brand, maxSpeed, priceCost,
                fuelConsumption, loadCapacity);
        return truck;
    }
}
