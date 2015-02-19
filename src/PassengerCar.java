
public class PassengerCar extends Car{
    private int passengerSeatsQuntity = 1;

    public PassengerCar (String brand, int maxSpeed, double fuelConsumption, int priceCost, int passengerSeatsQuantity){
        super(brand, maxSpeed, fuelConsumption, priceCost);
        this.passengerSeatsQuntity = passengerSeatsQuantity;
    }

    public int getPassengerSeatsQty(){
        return this.passengerSeatsQuntity;
    }

    @Override
    public String toString(){
        return super.toString() + ", количество мест: " + passengerSeatsQuntity;
    }
}
