package com.pavel.automanager.logic.builder;

import com.pavel.automanager.entity.Car;

/**
 * An abstract class, realisation of Builder-pattern for Car class and its subclasses. Contains all methods to initialize
 * fields of Car-class instance through method fill, and returns instance of Car by means of methods create() and build().
 *
 * @param <T> instance of Car entity
 * @param <B> instance of AbstractCarBuilder entity that creates Car instance
 */
public abstract class AbstractCarBuilder<T extends Car, B extends AbstractCarBuilder<T, B>> {
    private String brand;
    private int maxSpeed;
    private int priceCost;
    private double fuelConsumption;

    //List of methods that set fields for this Builder
    public B setBrand(String value){
        this.brand = value;
        return (B)this;
    }

    public B setMaxSpeed(int value){
        this.maxSpeed = value;
        return (B)this;
    }

    public B setPriceCost(int value){
        this.priceCost = value;
        return (B)this;
    }

    public B setFuelConsumption(double value){
        this.fuelConsumption = value;
        return (B)this;
    }

    /**
     * Receives instance of Car from create() method, fills its fields by fill() method and returns.
     * @return returns Car instance
     */
    public T build(){
        T car = this.create();
        this.fill(car);
        return car;
    }

    /**
     *
     * @return new Car instance
     */
    protected abstract T create();

    /**
     * Receives a Car instance and fills its fields
      * @param car
     */
    protected void fill(T car){
        car.setBrand(this.brand);
        car.setMaxSpeed(this.maxSpeed);
        car.setPriceCost(this.priceCost);
        car.setFuelConsumption(this.fuelConsumption);
    }

}
