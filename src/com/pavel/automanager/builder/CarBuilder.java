package com.pavel.automanager.builder;

import com.pavel.automanager.entity.baseclass.Car;

public class CarBuilder {
    protected Car car;

    protected String brand;
    protected int maxSpeed;
    protected int priceCost;
    protected double fuelConsumption;

    public CarBuilder(String brand){
        this.brand = brand;
    }

    public CarBuilder setMaxSpeed(int value){
        this.maxSpeed = value;
        return this;
    }

    public CarBuilder setPriceCost(int value){
        this.priceCost = value;
        return this;
    }

    public CarBuilder setFuelConsumption (double value){
        this.fuelConsumption = value;
        return this;
    }

    public Car build(){
        this.car = new Car(brand, maxSpeed, priceCost, fuelConsumption);
        return car;
    }
}
