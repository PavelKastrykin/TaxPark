package com.pavel.automanager.builder;

import com.pavel.automanager.entity.subclass.PassengerCar;

public class PassengerCarBuilder extends CarBuilder{

    private PassengerCar passengerCar;
    private int passengerSeatsQuantity;

    public PassengerCarBuilder(String brand){
        super(brand);
    }

    public PassengerCarBuilder setPassengerSeatsQuantity(int value){
        this.passengerSeatsQuantity = value;
        return this;
    }

    public PassengerCar build(){
        passengerCar = new PassengerCar(brand, maxSpeed, priceCost,
                fuelConsumption, passengerSeatsQuantity);
        return passengerCar;
    }
}
