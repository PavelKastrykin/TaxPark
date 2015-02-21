package com.pavel.automanager.entity.subclass;

import com.pavel.automanager.entity.baseclass.*;

public class PassengerCar extends Car{
    private final int passengerSeatsQuantity;

    public PassengerCar (String brand, int maxSpeed, int priceCost, double fuelConsumption, int passengerSeatsQuantity){
        super(brand, maxSpeed, priceCost, fuelConsumption);
        this.passengerSeatsQuantity = passengerSeatsQuantity;
    }

    public int getPassengerSeatsQty(){
        return this.passengerSeatsQuantity;
    }

    @Override
    public String toString(){
        return super.toString() + ", количество мест: " + passengerSeatsQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        PassengerCar that = (PassengerCar) o;

        if (passengerSeatsQuantity != that.passengerSeatsQuantity) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + passengerSeatsQuantity;
        return result;
    }
}
