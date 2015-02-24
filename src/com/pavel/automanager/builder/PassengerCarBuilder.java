package com.pavel.automanager.builder;

import com.pavel.automanager.entity.PassengerCar;

public class PassengerCarBuilder extends AbstractCarBuilder<PassengerCar, PassengerCarBuilder>{

    private int passengerSeatsQuantity;

    public PassengerCarBuilder setPassengerSeatsQuantity(int value){
        this.passengerSeatsQuantity = value;
        return this;
    }

    @Override
    protected  PassengerCar create(){
        return new PassengerCar();
    }

    @Override
    protected void fill(PassengerCar passengerCar){
        super.fill(passengerCar);
        passengerCar.setPassengerSeatsQuantity(this.passengerSeatsQuantity);
    }
}
