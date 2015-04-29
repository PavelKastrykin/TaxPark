package com.pavel.automanager.logic;

import com.pavel.automanager.logic.builder.CarBuilder;
import com.pavel.automanager.logic.builder.PassengerCarBuilder;
import com.pavel.automanager.logic.builder.TruckBuilder;
import com.pavel.automanager.entity.BuilderRequest;
import com.pavel.automanager.entity.Car;
import com.pavel.automanager.entity.TaxiPark;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that manages Taxi Parks and Cars, stored in them, by receiving commands and requests.
 * Contains storage of Taxi Parks, uses logics of TaxiParkLogic Class to manage single Taxi Park
 */
public class TaxiParkManager {

    private TaxiParkLogic taxiParkLogic = new TaxiParkLogic();
    private List<TaxiPark> taxiParkContainer = new ArrayList<TaxiPark>();

    /**
     * Here the result of TaxiParkLogic method findCarsWithGreaterSpeed() is written
     */
    private String foundCars;

    public static final Logger logger = Logger.getLogger(TaxiParkManager.class);

    public String getFoundCars() {
        return foundCars;
    }

    /**
     * This method receives Command and Request and fulfill actions following the logics as follows:
     * - taxi park name not specified: no action

     * - taxi park name specified:
     *      - if taxiParkContainer doesn't contain this taxi park - taxi park is created with command ADD_TAXIPARK_OR_CAR
     *        other commands - no action
     *      - if taxiParkContainer taxiParkContainer contains this taxi park all methods do their action according to
     *        if car name specified or not
     *
     *       - car name not specified: car not added or removed, but commands GET_CARS_WITH_SPEED_LIMIT and SORT_BY_FUEL_CONSUMPTION
     *          can be fulfilled
     *
     *       - car name specified - all commands fulfill their actions
     *
     * @param command receives command from enum Commands
     * @param request receives object of Request Class
     */
    public void execute(CommandTypes command, BuilderRequest request){

        switch (command){
            case ADD_TAXIPARK_OR_CAR:
                if (taxiParkIsValid(request)){
                    if (taxiParkIsExist(request)){
                        for (TaxiPark x : taxiParkContainer){
                            if (x.getTaxiParkName().equals(request.getTaxiParkName())){
                                if (carIsValid(request)){
                                    taxiParkLogic.addCar(x, carCreate(request));
                                    break;
                                }
                            }
                        }
                    }
                    else {
                        TaxiPark taxiPark = taxiParkCreate(request);
                        if (carIsValid(request)){
                            taxiParkLogic.addCar(taxiPark, carCreate(request));
                        }
                        taxiParkContainer.add(taxiPark);
                        break;
                    }
                }

                break;

            case REMOVE_CAR:
                if (taxiParkIsValid(request)){
                    if (taxiParkIsExist(request)){
                        if (carIsValid(request)){
                            for (TaxiPark x : taxiParkContainer){
                                if (x.getTaxiParkName().equals(request.getTaxiParkName())){
                                    taxiParkLogic.removeCar(x, carCreate(request));
                                    break;
                                }
                            }
                        }
                    }
                    else{
                        logger.info("Taxi Park with such name was not found, no Car removed");
                    }
                    break;

                }
                break;

            case GET_CARS_WITH_SPEED_LIMIT:
                if (taxiParkIsValid(request)){
                    for (TaxiPark x : taxiParkContainer){
                        if (x.getTaxiParkName().equals(request.getTaxiParkName())){
                            List<Car> foundCarsList = taxiParkLogic.findCarsWithGreaterSpeed(x, request.getMaxSpeed());
                            switch (foundCarsList.size()){
                                case 0:
                                    foundCars = "No cars according to speed limit " + request.getMaxSpeed() + " km/h found";
                                    logger.info(foundCars);
                                    break;
                                default:
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("Cars with speed limit ");
                                    sb.append(request.getMaxSpeed());
                                    sb.append(" km/h and over in Taxi Park ");
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
                if (taxiParkIsValid(request)){
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

    private boolean taxiParkIsValid(BuilderRequest request){
        if ("".equals(request.getTaxiParkName())){
            logger.info("No Taxi Park name");
            return false;
        }
        return true;
    }

    private boolean carIsValid(BuilderRequest request) {
        if ("".equals(request.getCarName())) {
            logger.info("No Car name");
            return false;
        }
        return true;
    }

    private boolean taxiParkIsExist(BuilderRequest request){
        for (TaxiPark x : taxiParkContainer){
            if (x.getTaxiParkName().equals(request.getTaxiParkName())){
                return true;
            }
        }
        return false;
    }

    private Car carCreate(BuilderRequest request) {
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
    private TaxiPark taxiParkCreate(BuilderRequest request){
        return new TaxiPark(request.getTaxiParkName());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Manager:\n");
        for (TaxiPark x : taxiParkContainer){
            sb.append(x.getTaxiParkName() + ":\n");
            sb.append(x.toString()).append("\n");
        }
        return sb.toString();
    }
}
