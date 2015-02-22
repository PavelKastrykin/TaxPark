import com.pavel.automanager.builder.CarBuilder;
import com.pavel.automanager.builder.PassengerCarBuilder;
import com.pavel.automanager.builder.TruckBuilder;
import com.pavel.automanager.entity.baseclass.Car;
import com.pavel.automanager.logic.TaxPark;

public class MainApplication {

    public static void main(String[] args){
        Car car = new CarBuilder().setBrand("Toyota").setPriceCost(1000).setFuelConsumption(3.2).setMaxSpeed(200).build();
        Car car1 = new CarBuilder(). setBrand("Mercedes").setPriceCost(2000).setFuelConsumption(5.2).setMaxSpeed(210).build();
        Car car2 = new PassengerCarBuilder().setBrand("Honda").setFuelConsumption(6.4).setPriceCost(3500)
                .setPassengerSeatsQuantity(4).build();
        Car car3 = new TruckBuilder().setBrand("MAN").setPriceCost(1000).setFuelConsumption(20).setMaxSpeed(100)
                .setLoadCapacity(200).build();
        TaxPark taxPark = new TaxPark();
        taxPark.addCar(car, car1, car2, car3);
        System.out.println(taxPark);

        System.out.println("Sort by fuel consumption");
        taxPark.sortByFuelConsumption();
        System.out.println(taxPark);

        System.out.println("Cars with speed over 150");
        System.out.println(taxPark.findCars(150));
    }
}
