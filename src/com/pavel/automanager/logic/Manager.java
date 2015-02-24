package com.pavel.automanager.logic;

import com.pavel.automanager.builder.CarBuilder;
import com.pavel.automanager.builder.PassengerCarBuilder;
import com.pavel.automanager.builder.TruckBuilder;
import com.pavel.automanager.entity.Car;
import com.pavel.automanager.entity.PassengerCar;
import org.apache.log4j.Logger;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Manager {
    private List<TaxPark> taxParkContainer = new ArrayList<TaxPark>();

    public static final Logger logger = Logger.getLogger(Manager.class);

    public void execute(Commands command, Request request){
        switch (command){
            case ADD_TAXPARK_OR_CAR:
                if (taxParkValidator(request)){
                    for (TaxPark x : taxParkContainer){
                        if (x.getTaxParkName().equals(request.getTaxParkName())){
                            if (carValidator(request)){

                            }
                        }
                    }
                }

                break;
            case REMOVE_CAR:
                break;
            case GET_CARS_WITH_SPEED_LIMIT:
                break;
            case SORT_BY_FUEL_CONSUMPTION:
                break;
        }
    }

    private boolean taxParkValidator(Request request){
        if ("".equals(request.getTaxParkName())){
            logger.info("No Taxi Park name");
            return false;
        }
        return true;
    }

    private boolean carValidator(Request request) {
        if ("".equals(request.getCarName())) {
            logger.info("No Car name added or removed");
            return false;
        }
        return true;
    }

//   private <T extends CarBuilder> T sampleCarCreate(Request request, Class<? extends CarBuilder> tClass)
//   throws InstantiationException, IllegalAccessException{
//        return (T)tClass.newInstance().setBrand(request.getCarName()).setMaxSpeed(request.getMaxSpeed())
//                .setPriceCost(request.getPriceCost()).setFuelConsumption(request.getFuelConsumption());
//   }

    private Car carCreate(Request request) throws InstantiationException, IllegalAccessException{
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
    private void addTaxPark(TaxPark taxParkLogic){

    }

}
