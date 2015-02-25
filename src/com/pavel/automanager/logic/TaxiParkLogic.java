package com.pavel.automanager.logic;

import com.pavel.automanager.entity.Car;
import com.pavel.automanager.entity.TaxiPark;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class that contains methods used to manage Taxi Park
 */
public class TaxiParkLogic {

    final static Logger logger = Logger.getLogger(TaxiParkLogic.class);

    /**
     * Adds car ("car"-parameter) to the Taxi Park ("taxiPark"-parameter)
     * @param taxiPark
     * @param car
     */
    public void addCar(TaxiPark taxiPark, Car car){
        taxiPark.getCarContainer().add(car);
    }

    /**
     * Removes car ("car"-parameter) from the Taxi Park ("taxiPark"-parameter), if contains
     * @param taxiPark
     * @param car
     */
    public void removeCar(TaxiPark taxiPark, Car car){
        if (taxiPark.getCarContainer().contains(car)){
            taxiPark.getCarContainer().remove(car);
        }
        else logger.info("No such car in this Taxi Park");
    }

    /**
     * Finds car with specified speed parameter and returns an ArrayList of them
     * @param taxiPark
     * @param speed
     * @return
     */
    public List<Car> findCarsWithGreaterSpeed(TaxiPark taxiPark, int speed){
        List<Car> foundCars = new ArrayList<Car>();
        for (Car x : taxiPark.getCarContainer()){
            if (x.getMaxSpeed() >= speed){
                foundCars.add(x);
            }
        }
        return foundCars;
    }

    /**
     * Sorts (ascending) cars in a Taxi Park according to their fuel consumption
     * @param taxiPark
     */
    public void sortCarsByFuelConsumption(TaxiPark taxiPark){
        Collections.sort(taxiPark.getCarContainer());
    }
}