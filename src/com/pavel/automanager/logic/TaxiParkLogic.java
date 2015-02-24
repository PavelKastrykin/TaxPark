package com.pavel.automanager.logic;

import com.pavel.automanager.entity.Car;
import com.pavel.automanager.entity.TaxiPark;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaxiParkLogic {

    final static Logger logger = Logger.getLogger(TaxiParkLogic.class);

    public void addCar(TaxiPark taxiPark, Car car){
        taxiPark.getCarContainer().add(car);
    }

    public void removeCar(TaxiPark taxiPark, Car car){
        if (taxiPark.getCarContainer().contains(car)){
            taxiPark.getCarContainer().remove(car);
        }
        else logger.info("No such car in this Taxi Park");
    }

    public List<Car> findCarsWithGreaterSpeed(TaxiPark taxiPark, int speed){
        List<Car> foundCars = new ArrayList<Car>();
        for (Car x : taxiPark.getCarContainer()){
            if (x.getMaxSpeed() >= speed){
                foundCars.add(x);
            }
        }
        return foundCars;
    }

    public void sortCarsByFuelConsumption(TaxiPark taxiPark){
        Collections.sort(taxiPark.getCarContainer());
    }
}