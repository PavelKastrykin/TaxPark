package com.pavel.automanager.entity;

/**
 * The subclass of Car base-class. Widens base-class with a field a field "passenger seats quantity".
 */
public class PassengerCar extends Car{
    private int passengerSeatsQuantity;

    public PassengerCar(){};

    public PassengerCar (String brand, int maxSpeed, int priceCost, double fuelConsumption, int passengerSeatsQuantity){
        super(brand, maxSpeed, priceCost, fuelConsumption);
        this.passengerSeatsQuantity = passengerSeatsQuantity;
    }

    public int getPassengerSeatsQantity(){
        return this.passengerSeatsQuantity;
    }

    public void setPassengerSeatsQuantity(int value){
        this.passengerSeatsQuantity = value;
    }

    @Override
    public String toString(){
        return super.toString() + ", quantity of seats: " + passengerSeatsQuantity;
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
