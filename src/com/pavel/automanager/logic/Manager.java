package com.pavel.automanager.logic;

import com.pavel.automanager.builder.CarBuilder;
import com.pavel.automanager.builder.PassengerCarBuilder;
import com.pavel.automanager.builder.TruckBuilder;
import com.pavel.automanager.entity.Car;
import com.pavel.automanager.entity.TaxiPark;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class Manager {

    private TaxiParkLogic taxiParkLogic;
    private List<TaxiPark> taxiParkContainer = new ArrayList<TaxiPark>();
    private String foundCars;

    public static final Logger logger = Logger.getLogger(Manager.class);

    public void execute(Commands command, Request request){
        switch (command){
            case ADD_TAXIPARK_OR_CAR:
                if (taxiParkValidator(request)){
                    for (TaxiPark x : taxiParkContainer){
                        if (x.getTaxiParkName().equals(request.getTaxiParkName())){
                            if (carValidator(request)){
                                taxiParkLogic.addCar(x, carCreate(request));
                                break;
                            }
                        }
                    }
                    TaxiPark taxiPark = taxiParkCreate(request);
                    if (carValidator(request)){
                        taxiParkLogic.addCar(taxiPark, carCreate(request));
                    }
                    taxiParkContainer.add(taxiPark);
                    break;
                }

                break;

            case REMOVE_CAR:
                if (taxiParkValidator(request)){
                    if (carValidator(request)){
                        for (TaxiPark x : taxiParkContainer){
                            if (x.getTaxiParkName().equals(request.getTaxiParkName())){
                                taxiParkLogic.removeCar(x, carCreate(request));
                                break;
                            }
                            else {
                                logger.info("Taxi Park with such name was not found, no Car removed");
                                break;
                            }
                        }
                    }
                }
                break;

            case GET_CARS_WITH_SPEED_LIMIT:
                if (taxiParkValidator(request)){
                    for (TaxiPark x : taxiParkContainer){
                        if (x.getTaxiParkName().equals(request.getTaxiParkName())){
                            List<Car> foundCarsList = taxiParkLogic.findCarsWithGreaterSpeed(x, request.getMaxSpeed());
                            switch (foundCarsList.size()){
                                case 0:
                                    foundCars = "No cars according to speed limit found";
                                    logger.info(foundCars);
                                    break;
                                default:
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("Cars with speed limit over ");
                                    sb.append(request.getMaxSpeed());
                                    sb.append(" in Taxi Park ");
                                    sb.append(request.getTaxiParkName());
                                    sb.append(" found: \n");
                                    for (Car y : foundCarsList){
                                        sb.append(y).append("\n");
                                    }
                                    foundCars = sb.toString();
                                    break;
                            }

                        }
                    }
                }
                break;

            case SORT_BY_FUEL_CONSUMPTION:
                if (taxiParkValidator(request)){
                    for (TaxiPark x : taxiParkContainer){
                        if (x.getTaxiParkName().equals(request.getTaxiParkName())){
                            taxiParkLogic.sortCarsByFuelConsumption(x);
                            break;
                        }
                        else {
                            logger.info("No such Taxi Park");
                        }
                    }
                }
                break;
        }
    }

    private boolean taxiParkValidator(Request request){
        if ("".equals(request.getTaxiParkName())){
            logger.info("No Taxi Park name");
            return false;
        }
        return true;
    }

    private boolean carValidator(Request request) {
        if ("".equals(request.getCarName())) {
            logger.info("No Car name");
            return false;
        }
        return true;
    }

    private Car carCreate(Request request) {
        switch (request.getCarType()){
            case CAR:
                return new CarBuilder().setBrand(request.getCarName()).setMaxSpeed(request.getMaxSpeed())
                        .setPriceCost(request.getPriceCost()).setFuelConsumption(request.getFuelConsumption()).build();

            case PASSENGER_CAR:
                return new PassengerCarBuilder().setBrand(request.getCarName()).setMaxSpeed(request.getMaxSpeed())
                        .setPriceCost(request.getPriceCost()).setFuelConsumption(request.getFuelConsumption())
                        .setPassengerSeatsQuantity(request.getPassengerSeatsQuantity()).build();

            case TRUCK:
                return new TruckBuilder().setBrand(request.getCarName()).setMaxSpeed(request.getMaxSpeed())
                        .setPriceCost(request.getPriceCost()).setFuelConsumption(request.getFuelConsumption())
                        .setLoadCapacity(request.getLoadCapacity()).build();
        }

        return null;
    }
    private TaxiPark taxiParkCreate(Request request){
        return new TaxiPark(request.getTaxiParkName());
    }

}
