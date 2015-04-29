package com.pavel.automanager.entity;

/**
 * Class for string requests parsing. Receives request of this kind:
 *
 * taxiParkName;carType;carName;maxSpeed;priceCost;fuelConsumption;passengerSeatsQuantity;loadCapacity
 * (delimiter is ';')
 *
 *  - and creates request object that bases on it
 */
public class BuilderRequest {
    private String taxiParkName;
    private CarType carType;
    private String carName;
    private int maxSpeed = 0;
    private int priceCost = 0;
    private double fuelConsumption = 0;
    private int passengerSeatsQuantity = 0;
    private int loadCapacity = 0;

    public enum CarType{
        CAR,
        PASSENGER_CAR,
        TRUCK
    }

    public BuilderRequest(String requestString){
        String[] requestStringToArray = requestString.split(";");
        switch (requestStringToArray.length){
            case 8:
                this.setTaxiParkName(requestStringToArray[0]);
                this.setCarType(CarType.valueOf(requestStringToArray[1]));
                this.setCarName(requestStringToArray[2]);
                this.setMaxSpeed(Integer.parseInt(requestStringToArray[3]));
                this.setPriceCost(Integer.parseInt(requestStringToArray[4]));
                this.setFuelConsumption(Double.parseDouble(requestStringToArray[5]));
                this.setPassengerSeatsQuantity(Integer.parseInt(requestStringToArray[6]));
                this.setLoadCapacity(Integer.parseInt(requestStringToArray[7]));
                break;
            case 2:
                this.setTaxiParkName(requestStringToArray[0]);
                this.setMaxSpeed(Integer.parseInt(requestStringToArray[1]));
                break;
            case 1:
                this.setTaxiParkName(requestStringToArray[0]);
                break;
        }

    }

    public String getTaxiParkName() {
        return taxiParkName;
    }
    public CarType getCarType() {
        return carType;
    }
    public String getCarName() {
        return carName;
    }
    public int getMaxSpeed() {
        return maxSpeed;
    }
    public int getPriceCost() {
        return priceCost;
    }
    public double getFuelConsumption() {
        return fuelConsumption;
    }
    public int getPassengerSeatsQuantity() {
        return passengerSeatsQuantity;
    }
    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setTaxiParkName(String taxiParkName) {
        this.taxiParkName = taxiParkName;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setMaxSpeed(int maxSpeed) {
        if (maxSpeed > 0){
            this.maxSpeed = maxSpeed;
        }
    }

    public void setPriceCost(int priceCost) {
        if (priceCost > 0){
            this.priceCost = priceCost;
        }
    }

    public void setFuelConsumption(double fuelConsumption) {
        if (fuelConsumption > 0){
            this.fuelConsumption = fuelConsumption;
        }
    }

    public void setPassengerSeatsQuantity(int passengerSeatsQuantity) {
        if (passengerSeatsQuantity > 0){
            this.passengerSeatsQuantity = passengerSeatsQuantity;
        }
    }

    public void setLoadCapacity(int loadCapacity) {
        if (loadCapacity > 0){
            this.loadCapacity = loadCapacity;
        }
    }
}
