package com.pavel.automanager.builder;


import com.pavel.automanager.entity.Truck;

public class TruckBuilder extends AbstractCarBuilder<Truck, TruckBuilder>{
    private int loadCapacity;

    public TruckBuilder setLoadCapacity(int value){
        this.loadCapacity = value;
        return this;
    }

    @Override
    protected Truck create(){
        return new Truck();
    }

    @Override
    protected void fill(Truck truck){
        super.fill(truck);
        truck.setLoadCapacity(this.loadCapacity);
    }
}
