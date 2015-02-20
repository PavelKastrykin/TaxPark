
public class Manager {

    public static void main(String[] args){
        TaxPark taxPark1 = new TaxPark();
        Car car = new PassengerCar.PassengerCarBuilder("Toyota").passengerSeatsQuantity(3).maxSpeed(100).
                fuelConsumption(6.1).priceCost(10000).build();
        Car car1 = new Truck.TruckBuilder("MAN").loadCapacity(10000).maxSpeed(80).fuelConsumption(31.0).build();
        Car car2 = new PassengerCar.PassengerCarBuilder("Toyota").passengerSeatsQuantity(3).maxSpeed(100).
                fuelConsumption(6.1).priceCost(10000).build();
        Car car3 = new Car.CarBuilder("Mercedes").build();
        taxPark1.addCar(car, car1, car2, car3);
        System.out.println(taxPark1);

        System.out.println(taxPark1.getCars().get(0));
        System.out.println(taxPark1.getCars().get(1));
        System.out.println(taxPark1.getCars().get(0).equals(taxPark1.getCars().get(1)));
        System.out.println();

        taxPark1.findCars(160);
        System.out.println();

        taxPark1.sortByFuelConsumption();
        System.out.println(taxPark1);

        System.out.println(taxPark1.getCars().get(1));
        System.out.println(taxPark1.getCars().get(2));
        System.out.println(taxPark1.getCars().get(1).equals(taxPark1.getCars().get(2)));
        System.out.println();

        taxPark1.removeCar(car2);
        System.out.println(taxPark1);
    }
}
