package com.pavel.automanager.logic;

import com.pavel.automanager.entity.baseclass.Car;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class TaxPark realises logic of car managing in an abstract taxi park.
 * Contains list to store added cars.
 *
 * To manage cars, methods of adding, removing, sorting and finding are provided
 * Initialized with a default constructor
 */
public class TaxPark{
    /** List of cars that taxi park contains*/
    private List<Car> taxPark = new ArrayList<Car>();
    /**
     * Method to add single car or array of cars
     * @param car
     *        A Car or array of them to be added
     */

    Logger logger = Logger.getLogger(TaxPark.class);

    public void addCar(Car... car){
        for (Car x : car) {
            taxPark.add(x);
        }
    }

    /**
     * Method to remove car
     * @param car
     *        A car to be removed
     */
    public void removeCar(Car car){
        if (taxPark.contains(car)){
            taxPark.remove(car);
        }
        else{
            logger.info("Item not found");
        }
    }

    /**
     * Returns current contention of car in the taxi park
     * @return  an ArrayList of Car
     */
    public List<Car> getCars(){
        return taxPark;
    }

    public int getCarCount(){
        return this.taxPark.size();
    }

    /**
     * Calculates total cost value of a taxi park
     * @return total cost
     */
    public int getTotalCostValue(){
        int amount = 0;
        for (Car x : this.taxPark){
            amount = amount + x.getPriceCost();
        }
        return amount;
    }

    /**
     * Returns List of cars that suit given speed parameter
     * @param speed
     *        speed value
     */
    public List<Car> findCars (int speed){
        List<Car> foundCars = new ArrayList<Car>();
        for (Car x : taxPark){
            if (x.getMaxSpeed() >= speed){
                foundCars.add(x);
            }
        }
        if (foundCars.size() == 0){
            logger.info("Cars are not found");
        }
        return foundCars;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Car x : this.taxPark){
            sb.append(x.toString());
            sb.append("\n");
        }
        sb.append("Всего машин: ");
        sb.append(getCarCount());
        sb.append("\n");
        sb.append("Общей стоимостью: ");
        sb.append(getTotalCostValue());
        sb.append("\n");
        return sb.toString();
    }

    /**
     * Method that makes ascending sort of cars in the taxi park according to their fuel consumption
     */
    public void sortByFuelConsumption() throws Exception{
        if (taxPark.size() == 0){
            throw new Exception("TaxPark is empty");
        }
        Collections.sort(this.taxPark);
    }
}